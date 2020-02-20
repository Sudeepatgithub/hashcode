public class Library {

    long noOfBooks, setupTime, daily;

    public long getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(long noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public long getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(long setupTime) {
        this.setupTime = setupTime;
    }

    public long getDaily() {
        return daily;
    }

    public void setDaily(long daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return "Library{" +
                "noOfBooks=" + noOfBooks +
                ", setupTime=" + setupTime +
                ", daily=" + daily +
                '}';
    }
}
