package com.datastructure.Algorithms.StringManipulation;

/*
 * ABBA
 * MADAM
 * If we read this from left or right it must be same
 */
public class Palindrome {
    public boolean v1(String word) {
        if (word == null)
            return false;

        var input = new StringBuilder(word);
        input.reverse();
        return input.toString().equals(word);
    }

    public boolean v2(String word) {
        if (word == null)
            return false;

        var left = 0;
        var right = word.length() - 1;

        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }
}
