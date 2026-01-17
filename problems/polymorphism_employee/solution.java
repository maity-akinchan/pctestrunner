public class Employee {
    public void role() {
        System.out.println("Employee role");
    }
}

class CSE extends Employee {
    @Override
    public void role() {
        System.out.print("CSE Employee");
    }
}
