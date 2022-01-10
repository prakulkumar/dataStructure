package com.datastructure.Algorithms.Searching;

public class BinarySearch {

    public int searchRecusively(int[] array, int target) {
        return searchRecusively(array, target, 0, array.length - 1);
    }

    public int searchRecusively(int[] array, int target, int left, int right) {
        // Base condition for recursion to stop
        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (target == array[middle])
            return middle;

        if (target < array[middle])
            return searchRecusively(array, target, left, middle - 1);

        return searchRecusively(array, target, middle + 1, right);
    }

    public int searchIteratively(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (target == array[middle])
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }
}
