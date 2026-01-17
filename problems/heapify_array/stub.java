import java.util.*;

public class Solution {

    // === BEGIN USER CODE ===
    public static void heapify(int[] arr) {
        // WRITE YOUR CODE HERE
    }
    // === END USER CODE ===

    static void siftDown(int[] arr, int i, int n) {
        int smallest = i;
        int l = 2*i + 1, r = 2*i + 2;

        if (l < n && arr[l] < arr[smallest]) smallest = l;
        if (r < n && arr[r] < arr[smallest]) smallest = r;

        if (smallest != i) {
            int t = arr[i]; arr[i] = arr[smallest]; arr[smallest] = t;
            siftDown(arr, smallest, n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 1};
        heapify(arr);
        System.out.print(arr[0]);
    }
}
