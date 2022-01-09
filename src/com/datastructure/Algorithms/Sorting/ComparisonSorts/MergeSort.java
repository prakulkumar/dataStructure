package com.datastructure.Algorithms.Sorting.ComparisonSorts;

public class MergeSort {
    /*
     * Divide this array into half
     * Sort each half
     * Merge the result
     */
    public void sort(int[] array) {
        // Base condition for recursion to stop
        if (array.length < 2)
            return;

        // Divide this array into half
        var middle = array.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        // Sort each half
        sort(left);
        sort(right);

        // Merge the result
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        /*
         * i to iterate over left array
         * j to iterate over right array
         * k to iterate over result array
         */
        int i = 0, j = 0, k = 0;

        /*
         * If length of left array is equal to right array
         * Compare values and put in result array in sorted form
         */
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        /*
         * If left array is longer than right array
         * Need to fill remaining items from left array to result array
         */
        while (i < left.length)
            result[k++] = left[i++];

        /*
         * If right array is longer than left array
         * Need to fill remaining items from right array to result array
         */
        while (j < right.length)
            result[k++] = right[j++];
    }
}
