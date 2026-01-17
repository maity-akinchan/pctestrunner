public class Shape {
    double area;
    double circumference;

    public Shape(double side, double radius) {
        area = side * side;
        circumference = 2 * Math.PI * radius;
    }

    public void printResults() {
        System.out.printf("%.2f %.2f", area, circumference);
    }
}
