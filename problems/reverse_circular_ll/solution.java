public static Node reverse(Node head) {
    if (head == null || head.next == head) return head;

    Node prev = null, curr = head, next;
    Node last = head;

    while (last.next != head) last = last.next;

    do {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    } while (curr != head);

    head.next = prev;
    last.next = prev;

    return prev;
}
