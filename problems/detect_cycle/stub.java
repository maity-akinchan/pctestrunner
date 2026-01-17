import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    // === BEGIN USER CODE ===
    public static boolean hasCycle(Node head) {
        // WRITE YOUR CODE HERE
        return false;
    }
    // === END USER CODE ===

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            System.out.print(false);
            return;
        }

        Node head = new Node(sc.nextInt());
        Node tail = head;

        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        tail.next = head; // create cycle
        System.out.print(hasCycle(head));
    }
}
