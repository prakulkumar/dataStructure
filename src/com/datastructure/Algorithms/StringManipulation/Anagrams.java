package com.datastructure.Algorithms.StringManipulation;

import java.util.Arrays;

/*
 * Anagrams -> same characters but in different sequence
 * ABCD - CBDA
 */
public class Anagrams {
    /*
     * ABCD - CBDA
     * ['A', 'B', 'C', 'D']
     * ['C', 'B', 'D', 'A']
     * Sort these arrays and then compare these arrays for equality
     * Time Complexity is O(n log n)
     */
    public boolean bySorting(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        // O(n)
        var array1 = first.toCharArray();
        var array2 = second.toCharArray();

        // O(n log n)
        Arrays.sort(array1);
        Arrays.sort(array2);

        // O(n)
        return Arrays.equals(array1, array2);
    }

    /*
     * Count number of each character in both of the string
     * Time Complexity is O(n)
     */
    public boolean byHistogramming(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        // O(n)
        for (int i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        // O(n)
        for (int i = 0; i < second.length(); i++) {
            int index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }
}
