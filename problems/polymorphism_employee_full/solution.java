public class Employee {
    public void role() {
        System.out.println("Employee");
    }
}

class ME extends Employee {
    @Override
    public void role() {
        System.out.print("Mechanical Engineer");
    }
}
