package com.datastructure.Algorithms.Sorting;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /*
     * Partition
     * Sort left
     * Sort right
     */
    private void sort(int[] array, int start, int end) {
        /*
         * Base condition to stop recursion
         * (start == end) have 1 item in array
         * (start > end) have empty array
         */
        if (start >= end)
            return;

        var boundary = partition(array, start, end);
        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);
    }

    /*
     * Give index of pivot after it moved to its correct position
     * Means final position of boundary
     */
    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for (int i = start; i <= end; i++)
            if (array[i] <= pivot)
                swap(array, i, ++boundary);

        return boundary;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
