package com.datastructure.Algorithms.StringManipulation;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedChar {
    public char v1(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        Map<Character, Integer> frequencies = new HashMap<>();

        for (var ch : str.toCharArray()) {
            if (frequencies.containsKey(ch))
                frequencies.replace(ch, frequencies.get(ch) + 1);
            else
                frequencies.put(ch, 1);
        }

        var maxEntry = frequencies.entrySet()
                .stream()
                .max((e1, e2) -> e1.getValue()
                        .compareTo(e2.getValue()));

        return maxEntry.get().getKey();
    }

    public char v2(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];

        /*
         * a = 61
         * initially frequencies['a'] = 0
         * as we find more a we increase this number
         */
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (int i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

        return result;
    }
}
