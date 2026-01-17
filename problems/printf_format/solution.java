public class Calculator {
    double a, b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void print() {
        double sum = a + b;
        double avg = sum / 2;
        System.out.printf("%.2f %.2f", sum, avg);
    }
}
