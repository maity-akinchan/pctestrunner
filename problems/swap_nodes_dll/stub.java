import java.util.*;

public class Solution {

    static class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    // === BEGIN USER CODE ===
    public static Node swap(Node head, int x, int y) {
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
                node.prev = tail;
                tail = node;
            }
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        head = swap(head, x, y);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
