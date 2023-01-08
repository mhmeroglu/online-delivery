import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "src//sampleinput1.txt";

        //read text
        LinkedList<String> list = readFile(fileName);

        //first line in txt so the size
        int size = Integer.parseInt(list.removeFirst().replace(" ", ""));

        //for customers information
        LinkedList<Customer> customers = new LinkedList<Customer>();

        //to customer linked list
        while (!list.isEmpty()) {
            String arr[] = (list.getFirst().split(" "));
            customers.add(new Customer(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
            list.removeFirst();
        }

        //heap based pq
        MinPQ pq = new MinPQ(size);

        //Couriers
        Courier c1 = new Courier(0, true, 0);
        Courier c2 = new Courier(1, true, 0);
        Courier c3 = new Courier(2, true, 0);

        System.out.println("Simulation with 3 couriers: \n");

        //with three courier
        withThreeCourier(customers,pq,c1,c2,c3);
    }

    static void withThreeCourier(LinkedList<Customer> customers, MinPQ pq, Courier c1,Courier c2,Courier c3){
//--------------------------------------------------------
// Summary:in this method calculations are made and the result is printed
// Precondition: customer is LinkedList, pq is Heap Based PQ and c1,c2,c3 are Courier
// Postcondition: Values are printed with using MinPQ.
//--------------------------------------------------------
        //for calculating wait mins
        int a = 0;
        int b = 0;
        int c = 0;

        //based loop and our time
        for (int i = 1; i < 1000; i++) {
            //customer list to pq
            for (int j = 0; j < customers.size(); j++) {
                if (customers.getFirst().getOrderMinute() == i) {
                    pq.insert(customers.getFirst());
                    customers.removeFirst();
                }
            }
            //for courier
            while (c1.isAvailable() || c2.isAvailable() || c3.isAvailable()) {
                if (c1.isAvailable()) {
                    Customer temp = (Customer) pq.delMin();
                    System.out.println("Courier " + c1.getID() + " takes customer " + temp.getCustomerQueue() + " at minute " + i );
                    c1.setAvailable(false);
                    c1.setServiceMinute(temp.getWaitingMinute());
                } else if (c2.isAvailable()) {
                    Customer temp = (Customer) pq.delMin();
                    System.out.println("Courier " + c2.getID() + " takes customer " + temp.getCustomerQueue() + " at minute " + i );
                    c2.setAvailable(false);
                    c2.setServiceMinute(temp.getWaitingMinute());
                } else if (c3.isAvailable()) {
                    Customer temp = (Customer) pq.delMin();
                    System.out.println("Courier " + c3.getID() + " takes customer " + temp.getCustomerQueue() + " at minute " + i );
                    c3.setAvailable(false);
                    c3.setServiceMinute(temp.getWaitingMinute());
                }
            }

            a = i-c1.getServiceMinute();
            b = i-c2.getServiceMinute();
            c = i-c3.getServiceMinute();

            //calculate the service min
            c1.setServiceMinute(c1.getServiceMinute() - 1);
            c2.setServiceMinute(c2.getServiceMinute() - 1);
            c3.setServiceMinute(c3.getServiceMinute() - 1);

            //is available
            if (c1.getServiceMinute() == 0) {
                c1.setAvailable(true);
            }
            if (c2.getServiceMinute() == 0) {
                c2.setAvailable(true);
            }
            if (c3.getServiceMinute() == 0) {
                c3.setAvailable(true);
            }

            //for stop the code
            if (pq.isEmpty()) {
                break;
            }
        }
    }

    static LinkedList<String> readFile(String path) throws IOException {
//--------------------------------------------------------
// Summary: In this function we read the files.
// Precondition: path is String for txt file names.
// Postcondition: txt file read and transferred to list.
//--------------------------------------------------------
        BufferedReader in = new BufferedReader(new FileReader(path));
        String str;

        LinkedList<String> list = new LinkedList<>();
        while ((str = in.readLine()) != null) {
            list.add(str);
        }
        return list;
    }
}