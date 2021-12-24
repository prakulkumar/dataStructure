package com.datastructure.HashTable;

import java.util.HashSet;
import java.util.Set;

public class ImplementSet {
    public void execute() {
        Set<Integer> set = new HashSet<>();
        int[] array = { 1, 2, 3, 3, 4, 5, 6, 2 };

        for (int i : array)
            set.add(i);

        System.out.println(set);
    }
}
