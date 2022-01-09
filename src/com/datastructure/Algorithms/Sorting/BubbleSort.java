package com.datastructure.Algorithms.Sorting;

public class BubbleSort {
    /*
     * 1st array is for count pass
     * 2nd array is for compare values
     */
    public void sort(int[] array) {
        // If in between any pass array gets sorted this will safe our loop
        boolean sorted;
        for (int i = 0; i < array.length; i++) {
            sorted = true;

            // (array.length - i) because with every pass last item is getting sorted
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    sorted = false;
                }
            }

            if (sorted)
                return;
        }
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
