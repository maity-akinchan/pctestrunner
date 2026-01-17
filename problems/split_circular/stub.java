import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    // === BEGIN USER CODE ===
    public static Node[] split(Node head) {
        // WRITE YOUR CODE HERE
        return null;
    }
    // === END USER CODE ===

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) return;

        Node head = new Node(sc.nextInt());
        Node tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }
        tail.next = head;

        Node[] parts = split(head);

        Node h1 = parts[0], h2 = parts[1];

        Node c = h1;
        if (c != null) {
            do {
                System.out.print(c.data + " ");
                c = c.next;
            } while (c != h1);
        }
        System.out.println();

        c = h2;
        if (c != null) {
            do {
                System.out.print(c.data + " ");
                c = c.next;
            } while (c != h2);
        }
    }
}
