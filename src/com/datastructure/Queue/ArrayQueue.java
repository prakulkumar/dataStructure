package com.datastructure.Queue;

import java.util.Arrays;

public class ArrayQueue {
    /*
     * [10, 20, 30, 40]
     * F R
     * Add new item increment R
     * Remove item increment F
     */
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear++] = item;
        count++;
    }

    /*
     * [0, 0, 30, 40, 50]
     * problem of filled remaining place of index 0 and 1
     * Use Circular Array
     * [60, 70, 30, 40, 50]
     * 
     * 5th index now is 0 index
     * 6th index now is 1 index
     * 7th index now is 2 index
     * 
     * Relation between these index is 
     * Left % Length
     * (rear + 1) % length
     */
    public int dequeue() {
        var item = items[front];
        items[front++] = 0;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
