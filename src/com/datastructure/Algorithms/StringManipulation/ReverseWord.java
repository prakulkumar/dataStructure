package com.datastructure.Algorithms.StringManipulation;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWord {
    public String v1(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
            reversed.append(words[i] + " ");

        return reversed.toString().trim();
    }

    public String v2(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words).trim();
    }
}
