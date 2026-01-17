static class Stack {
    int top = -1;
    int[] arr = new int[100];

    void push(int x) {
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) return -1;
        return arr[top--];
    }
}
