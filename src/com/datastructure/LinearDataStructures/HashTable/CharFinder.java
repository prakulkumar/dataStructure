package com.datastructure.LinearDataStructures.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> characters = new HashMap<>();

        var chars = str.toCharArray();
        for (char ch : chars) {
            var count = characters.containsKey(ch) ? characters.get(ch) : 0;
            characters.put(ch, count + 1);
        }

        for (char ch : chars)
            if (characters.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    public char FindFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
