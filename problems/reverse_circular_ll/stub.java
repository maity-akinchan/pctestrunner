import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    // === BEGIN USER CODE ===
    public static Node reverse(Node head) {
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

        head = reverse(head);

        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
    }
}
