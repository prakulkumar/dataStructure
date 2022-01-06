package com.datastructure.NonLinearDataStructure.Heap;

public class HeapSort {
    private int[] numbers;
    private Heap heap;

    public HeapSort(int[] numbers) {
        this.numbers = numbers;
        this.heap = new Heap(20);
    }

    public int[] descendingSort() {
        for (var number : numbers)
            heap.insert(number);

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = heap.remove();

        return numbers;
    }

    public int[] ascendingSort() {
        for (var number : numbers)
            heap.insert(number);

        for (int i = numbers.length - 1; i >= 0; i--)
            numbers[i] = heap.remove();

        return numbers;
    }
}
