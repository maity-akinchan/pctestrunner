public static void minHeapInsert(List<Integer> heap, int val) {
    heap.add(val);
    int i = heap.size() - 1;

    while (i > 0) {
        int p = (i - 1) / 2;
        if (heap.get(p) <= heap.get(i)) break;
        Collections.swap(heap, p, i);
        i = p;
    }
}
