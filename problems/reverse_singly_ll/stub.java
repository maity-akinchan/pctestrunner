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

        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        head = reverse(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
