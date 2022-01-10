package com.datastructure.Algorithms.StringManipulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowels {
    public int v1(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";

        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    public int v2(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";

        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.contains(Character.toString(ch)))
                count++;

        return count;
    }

    public int v3(String str) {
        if (str == null)
            return 0;

        int count = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.contains(ch))
                count++;

        return count;
    }
}
