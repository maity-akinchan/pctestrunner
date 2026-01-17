public class ParkingSystem {
    String carNo;
    int hours;

    public ParkingSystem(String carNo, int hours) {
        this.carNo = carNo;
        this.hours = hours;
    }

    public void printDetails() {
        System.out.print(carNo + " " + (hours * 20));
    }
}
