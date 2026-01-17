public static Node copyList(Node head) {
    if (head == null) return null;

    Node newHead = new Node(head.data);
    Node currOld = head.next;
    Node currNew = newHead;

    while (currOld != null) {
        currNew.next = new Node(currOld.data);
        currNew = currNew.next;
        currOld = currOld.next;
    }
    return newHead;
}
