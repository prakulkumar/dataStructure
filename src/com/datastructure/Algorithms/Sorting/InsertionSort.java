package com.datastructure.Algorithms.Sorting;

public class InsertionSort {
    public void sort(int[] array) {
        // Start with index 1 because we assume first item is at right place
        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = current;
        }
    }
}
