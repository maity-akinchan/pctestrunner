import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int normal = sc.nextInt();
        int vip = sc.nextInt();

        SecurityGate sg = new SecurityGate();
        sg.enterNormal(normal);
        sg.enterVIP(vip);
        sg.print();
    }
}
