import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int month = sc.nextInt();

        DateCounter d = new DateCounter(day, month);
        d.increment();
        d.print();
    }
}
