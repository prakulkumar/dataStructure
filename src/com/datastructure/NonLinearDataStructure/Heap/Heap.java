package com.datastructure.NonLinearDataStructure.Heap;

public class Heap {
    private int[] items;
    private int size; // require to remove item virtually

    public Heap(int capacity) {
        this.items = new int[capacity];
    }

    public void insert(int value) {
        if (isArrayFull())
            throw new IllegalStateException();

        items[size++] = value;

        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;

        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public boolean isArrayFull() {
        return size == items.length;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    /* ***************** Remove ***************** */

    public int remove() {
        if (isArrayEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];

        bubbleDown();
        return root;
    }

    public boolean isArrayEmpty() {
        return size == 0;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largestChildIndex = largestChildIndex(index);
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private int largestChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return items[index] >= leftChild(index);

        return items[index] >= leftChild(index) &&
                items[index] >= rightChild(index);
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public int max() {
        if (isArrayEmpty())
            throw new IllegalStateException();

        return items[0];
    }
}
