import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();

        DateTime dt = new DateTime();
        dt.setDate(d, m, y);
        dt.print();
    }
}
