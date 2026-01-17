public static int kthLargest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int x : arr) {
        pq.add(x);
        if (pq.size() > k) pq.poll();
    }
    return pq.peek();
}
