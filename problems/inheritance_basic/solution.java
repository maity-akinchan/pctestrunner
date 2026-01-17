public class Parent {
    public void show() {
        System.out.println("This is Parent class");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.print("This is Child class");
    }
}
