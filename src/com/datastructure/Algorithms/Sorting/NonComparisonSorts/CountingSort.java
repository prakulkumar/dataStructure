package com.datastructure.Algorithms.Sorting.NonComparisonSorts;

public class CountingSort {
    public void sort(int[] array) {
        sort(array, maxValue(array));
    }

    private void sort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for (var item : array)
            counts[item]++;

        var k = 0;
        for (int i = 0; i < counts.length; i++)
            for (int j = 0; j < counts[i]; j++)
                array[k++] = i;
    }

    private int maxValue(int[] array) {
        var maxValue = 0;
        for (int item : array)
            if (item > maxValue)
                maxValue = item;

        return maxValue;
    }
}
