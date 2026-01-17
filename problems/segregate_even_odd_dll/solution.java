public static Node segregate(Node head) {
    if (head == null) return null;

    Node evenHead = null, evenTail = null;
    Node oddHead = null, oddTail = null;

    Node curr = head;
    while (curr != null) {
        Node next = curr.next;
        curr.prev = curr.next = null;

        if (curr.data % 2 == 0) {
            if (evenHead == null) evenHead = evenTail = curr;
            else {
                evenTail.next = curr;
                curr.prev = evenTail;
                evenTail = curr;
            }
        } else {
            if (oddHead == null) oddHead = oddTail = curr;
            else {
                oddTail.next = curr;
                curr.prev = oddTail;
                oddTail = curr;
            }
        }
        curr = next;
    }

    if (evenTail != null) {
        evenTail.next = oddHead;
        if (oddHead != null) oddHead.prev = evenTail;
        return evenHead;
    }
    return oddHead;
}
