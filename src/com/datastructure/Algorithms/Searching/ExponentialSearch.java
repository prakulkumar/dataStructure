package com.datastructure.Algorithms.Searching;

public class ExponentialSearch {
    public int search(int[] array, int target) {
        int bound = 1;

        while (bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);

        return binarySearch(array, target, left, right);
    }

    public int binarySearch(int[] array, int target, int left, int right) {
        // Base condition for recursion to stop
        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (target == array[middle])
            return middle;

        if (target < array[middle])
            return binarySearch(array, target, left, middle - 1);

        return binarySearch(array, target, middle + 1, right);
    }
}
