package com.datastructure.LinearDataStructures.Trees.Heap;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap(20);

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isArrayEmpty();
    }
}
