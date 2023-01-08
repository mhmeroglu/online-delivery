public class Customer implements Comparable<Customer> {
    private int customerQueue;
    private int membershipYear;
    private int orderMinute;
    private int waitingMinute;

    public Customer(int customerQueue, int membershipYear, int orderMinute, int waitingMinute) {
        this.customerQueue = customerQueue;
        this.membershipYear = membershipYear;
        this.orderMinute = orderMinute;
        this.waitingMinute = waitingMinute;
    }

    public int getCustomerQueue() {
        return customerQueue;
    }

    public int getMembershipYear() {
        return membershipYear;
    }

    public int getOrderMinute() {
        return orderMinute;
    }

    public int getWaitingMinute() {
        return waitingMinute;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerQueue=" + customerQueue +
                ", membershipYear=" + membershipYear +
                ", orderMinute=" + orderMinute +
                ", waitingMinute=" + waitingMinute +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        if (this.membershipYear > o.membershipYear) {
            return 1;
        } else if (this.membershipYear < o.membershipYear) {
            return -1;
        } else {
            if(this.customerQueue > o.customerQueue){
                return 1;
            }
            else if(this.customerQueue < o.customerQueue){
                return -1;
            }
            return 0;
        }
    }
}
