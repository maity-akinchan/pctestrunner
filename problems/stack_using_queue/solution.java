static class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.poll());
        }
    }

    int pop() {
        return q.isEmpty() ? -1 : q.poll();
    }
}
