public static void heapify(int[] arr) {
    int n = arr.length;
    for (int i = n/2 - 1; i >= 0; i--) {
        siftDown(arr, i, n);
    }
}
