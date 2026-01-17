import java.util.*;

public class Solution {

    // === BEGIN USER CODE ===
    public static void minHeapInsert(List<Integer> heap, int val) {
        // WRITE YOUR CODE HERE
    }
    // === END USER CODE ===

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        minHeapInsert(heap, 10);
        minHeapInsert(heap, 5);
        minHeapInsert(heap, 20);
        System.out.print(heap.get(0));
    }
}
