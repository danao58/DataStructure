package tree.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
