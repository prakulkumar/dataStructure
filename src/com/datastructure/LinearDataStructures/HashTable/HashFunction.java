package com.datastructure.LinearDataStructures.HashTable;

// Assume array is of size 100
public class HashFunction {
    public int hashFromInteger(int key) {
        return key % 100;
    }

    public int hashFromString(String key) {
        int hash = 0;
        for (char ch : key.toCharArray())
            hash += ch;

        return hash % 100;
    }
}
