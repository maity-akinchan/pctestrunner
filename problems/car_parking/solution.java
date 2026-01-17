public class Parking {
    String carNo;
    int hours;

    public Parking(String carNo, int hours) {
        this.carNo = carNo;
        this.hours = hours;
    }

    public void printBill() {
        System.out.print(carNo + " " + (hours * 20));
    }
}
