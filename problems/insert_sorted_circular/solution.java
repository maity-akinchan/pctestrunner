public static Node insertSorted(Node head, int val) {
    Node newNode = new Node(val);

    if (head == null) {
        newNode.next = newNode;
        return newNode;
    }

    Node curr = head;

    if (val <= head.data) {
        while (curr.next != head) curr = curr.next;
        curr.next = newNode;
        newNode.next = head;
        return newNode;
    }

    while (curr.next != head && curr.next.data < val) {
        curr = curr.next;
    }

    newNode.next = curr.next;
    curr.next = newNode;
    return head;
}
