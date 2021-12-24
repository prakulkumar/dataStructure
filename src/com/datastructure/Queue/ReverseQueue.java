package com.datastructure.Queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    /*
     * Q [10, 20, 30]
     * S []
     * 
     * Q []
     * S [10, 20, 30] using push to add value in S from Q
     * 
     * Q [30, 20, 10]
     * S [] using pop to put values in Q
     */
    public void reverse(Queue<Integer> queue) {
        var stack = new Stack<Integer>();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.empty())
            queue.add(stack.pop());
    }
}
