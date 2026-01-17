import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node next;
        Node(int d) { data = d; }
    }

    // === BEGIN USER CODE ===
    public static Node insertSorted(Node head, int val) {
        // WRITE YOUR CODE HERE
        return null;
    }
    // === END USER CODE ===

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        if (tail != null) tail.next = head;
        int val = sc.nextInt();

        head = insertSorted(head, val);

        Node curr = head;
        if (curr != null) {
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);
        }
    }
}
