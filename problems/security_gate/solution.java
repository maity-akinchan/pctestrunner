public class SecurityGate {
    int visitors = 0;
    int cash = 0;

    public void enterNormal(int n) {
        visitors += n;
        cash += n * 50;
    }

    public void enterVIP(int n) {
        visitors += n;
    }

    public void print() {
        System.out.print(visitors + " " + cash);
    }
}
