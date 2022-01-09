package com.datastructure.Algorithms.Sorting.ComparisonSorts;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var minIndex = getMinimumIndex(array, i);
            swap(array, minIndex, i);
        }
    }

    private int getMinimumIndex(int[] array, int index) {
        var minIndex = index;
        for (int j = index; j < array.length; j++)
            if (array[j] < array[minIndex])
                minIndex = j;
        return minIndex;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
