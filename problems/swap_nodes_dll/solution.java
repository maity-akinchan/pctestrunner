public static Node swap(Node head, int x, int y) {
    if (x == y) return head;

    Node a = head, b = head;
    while (a != null && a.data != x) a = a.next;
    while (b != null && b.data != y) b = b.next;

    if (a == null || b == null) return head;

    int temp = a.data;
    a.data = b.data;
    b.data = temp;

    return head;
}
