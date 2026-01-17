public class DateTime {
    int d, m, y;

    public void setDate(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public void print() {
        System.out.print(d + "/" + m + "/" + y);
    }
}
