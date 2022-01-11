package com.datastructure.Algorithms.StringManipulation;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public String v1(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }
}
