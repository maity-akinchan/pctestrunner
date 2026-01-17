import java.util.*;

public class Solution {

    // === BEGIN USER CODE ===
    static class Stack {
        int top = -1;
        int[] arr = new int[100];

        void push(int x) {
            // WRITE YOUR CODE HERE
        }

        int pop() {
            // WRITE YOUR CODE HERE
            return -1;
        }
    }
    // === END USER CODE ===

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        System.out.print(s.pop());
    }
}
