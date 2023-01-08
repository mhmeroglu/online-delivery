public class Courier {
    private int ID;

    private boolean isAvailable;

    private int serviceMinute;

    public Courier(int ID, boolean isAvailable, int serviceMinute) {
        this.ID = ID;
        this.isAvailable = isAvailable;
        this.serviceMinute = serviceMinute;
    }

    public int getID() {
        return ID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getServiceMinute() {
        return serviceMinute;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setServiceMinute(int serviceMinute) {
        this.serviceMinute = serviceMinute;
    }
}
