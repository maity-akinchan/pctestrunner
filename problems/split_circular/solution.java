public static Node[] split(Node head) {
    Node slow = head, fast = head;

    while (fast.next != head && fast.next.next != head) {
        slow = slow.next;
        fast = fast.next.next;
    }

    Node head1 = head;
    Node head2 = slow.next;

    slow.next = head1;

    Node curr = head2;
    while (curr.next != head) curr = curr.next;
    curr.next = head2;

    return new Node[]{head1, head2};
}
