package com.datastructure.LinearDataStructures.Trees.Heap;

public class MaxHeap {
    private int[] array;

    public MaxHeap(int[] array) {
        this.array = array;
    }

    public void heapify() {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(i);
    }

    public void heapify(int index) {
        var largerIndex = largerIndex(index);

        if (index == largerIndex)
            return;

        swap(index, largerIndex);
        heapify(largerIndex);
    }

    private int largerIndex(int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        return largerIndex;
    }

    private void swap(int index, int largerIndex) {
        var temp = array[index];
        array[index] = array[largerIndex];
        array[largerIndex] = temp;
    }
}
