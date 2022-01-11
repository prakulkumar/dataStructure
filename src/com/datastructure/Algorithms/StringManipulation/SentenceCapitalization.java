package com.datastructure.Algorithms.StringManipulation;

public class SentenceCapitalization {
    public String v1(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        // (" +", " ") regex to remove multiple spaces
        String[] words = sentence
                .trim().replaceAll(" +", " ").split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }
}
