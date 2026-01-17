import java.util.*;

public class Solution {

    // === BEGIN USER CODE ===
    public static String convert(String s) {
        // WRITE YOUR CODE HERE
        return "";
    }
    // === END USER CODE ===

    static int prec(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(convert(s));
    }
}
