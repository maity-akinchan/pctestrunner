public static int length(Node head) {
    if (head == null) return 0;

    int len = 1;
    Node curr = head.next;
    while (curr != head) {
        len++;
        curr = curr.next;
    }
    return len;
}
