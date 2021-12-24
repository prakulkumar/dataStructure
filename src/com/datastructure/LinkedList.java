package com.datastructure;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    /*
     * Create a Node
     * If first node is null
     * make first and last equal to new node
     * else change ref of prev last node to new node
     * then last node equals to new node
     */
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    /*
     * Create a Node
     * If first node is null
     * make first and last equal to new node
     * else change ref of prev first node to new node
     * then first node equals to new node
     */
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addAtKth(int item, int index) {
        var node = new Node(item);
        var a = first;

        if (isEmpty())
            first = last = node;

        if (index == 0) {
            addFirst(item);
            return;
        } else if (index > size || index < 0) {
            throw new IllegalArgumentException();
        } else if (index == size) {
            addLast(item);
            return;
        }

        for (int i = 0; i < index - 1; i++)
            a = a.next;

        var next = a.next;
        a.next = node;
        node.next = next;

        size++;
    }

    /*
     * Create new variable index and set to 0
     * Create new variable current and set to first node
     * Iterate till current not equals to null
     * If value of current node is equals to item then return index
     * Set current node equals to next node
     * Increment index
     */
    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    /*
     * If list is empty throw exception
     * If only have one node then make first and last to null
     * Otherwise
     * Create a variable "second" and put second node into it
     * Break link between first and second node
     * Now set the "second" variable value to first node
     */
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    /*
     * If list is empty throw exception
     * If only have one node then make first and last to null
     * Otherwise
     * Get previous node
     * Break link between last and previous node
     * Make last node equals to previous node
     */
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        else if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    public void removeAtKth(int index) {
        if (isEmpty())
            throw new NoSuchElementException();

        if (index > size || index < 0) {
            throw new IllegalArgumentException();
        } else if (index == size) {
            removeLast();
            return;
        } else if (index == 0) {
            removeFirst();
            return;
        }

        var a = first;

        for (int i = 0; i < index; i++)
            a = a.next;

        var next = a.next;
        var previous = getPrevious(a);
        previous.next = next;
        a.next = null;

        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        var array = new int[size];
        var current = first;
        int index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    /*
     * [10 <- 20 30]
     * p c n
     */
    public void reverse() {
        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    /*
     * [10 -> 20 -> 30 -> 40 -> 50]
     * * *
     * distance between 2 pointers is "k - 1"
     */
    public int getkthFromTheEnd(int k) {
        if (isEmpty())
            throw new IllegalStateException();

        if (k > size)
            throw new IllegalArgumentException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++)
            b = b.next;

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }
}
