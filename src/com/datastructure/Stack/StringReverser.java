package com.datastructure.Stack;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();

        for (char value : input.toCharArray())
            stack.push(value);

        var reversedInput = new StringBuffer();

        while (!stack.empty())
            reversedInput.append(stack.pop());

        return reversedInput.toString();
    }
}
