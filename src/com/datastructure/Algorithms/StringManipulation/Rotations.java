package com.datastructure.Algorithms.StringManipulation;

public class Rotations {
    /*
     * Rotate by 1 ABCD -> DABC
     * Rotate by 2 ABCD -> CDAB
     * Rotate by 3 ABCD -> BCDA
     * Rotate by 4 ABCD -> ABCD
     */
    public String rotateStringBy(String str, int rotateBy) {
        if (str == null)
            return "";

        var mode = rotateBy % str.length();
        if (mode == 0)
            return str;

        var firstLetters = str.substring(str.length() - mode, str.length());
        var lastLetters = str.substring(0, str.length() - mode);

        return firstLetters + lastLetters;
    }

    public boolean areRotaions(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() && (str1 + str1).contains(str2));
    }
}
