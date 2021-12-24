package com.datastructure.LinearDataStructures.HashTable;

import java.util.LinkedList;

public class HashTable {
    /*
     * very important to store key and value together
     * To solve this use array of LinkedList
     * LinkedList<Entry>[]
     * [LL, LL, LL]
     */
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        var bucket = getOrCreateBucket(key);
        bucket.add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);

        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);

        if (entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);

        if (!bucket.isEmpty())
            for (var entry : bucket) {
                if (entry.key == key) {
                    return entry;
                }
            }

        return null;
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        int index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            entries[index] = new LinkedList<>();

        return bucket;
    }

    private int hash(int key) {
        return key % entries.length;
    }
}
