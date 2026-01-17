import java.util.*;

public class Solution {

    // === BEGIN USER CODE ===
    static class StackUsingQueue {
        Queue<Integer> q = new LinkedList<>();

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
        StackUsingQueue s = new StackUsingQueue();
        s.push(1);
        s.push(2);
        System.out.print(s.pop());
    }
}
