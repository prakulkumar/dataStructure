package com.datastructure.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckBalancedString {
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public Boolean isBalanced(String input) {
        var stack = new Stack<Character>();

        for (char ch : input.toCharArray()) {
            if (checkLeftBracket(ch))
                stack.push(ch);

            if (checkRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }
        }

        return stack.empty();
    }

    public Boolean checkLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    public Boolean checkRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    public Boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
