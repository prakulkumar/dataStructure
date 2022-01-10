package com.datastructure.Algorithms.StringManipulation;

public class ReverseString {
    // Time Complexity is O(n^2)
    public String v1(String str) {
        if (str == null)
            return "";

        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) // O(n)
            reversed += str.charAt(i); // O(n)

        return reversed;
    }

    // Time Complexity is O(n)
    public String v2(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) // O(n)
            reversed.append(str.charAt(i)); // O(1)

        return reversed.toString();
    }
}
