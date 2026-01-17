public class Parent {
    public void display() {
        System.out.println("This is parent class");
    }
}

class Child extends Parent {
    @Override
    public void display() {
        System.out.print("This is child class");
    }
}
