package com.datastructure.Queue;

import java.util.Stack;

/*
* Use two stacks to create a queue.
* 
* Q [40, 50]
* 
* For enqueue
* add items to S1 []
* 
* For dequeue
* move data from S1 [] to S2 [] and then pop from S2 []
*/
public class StackQueue {
    private Stack<Integer> stack_1 = new Stack<Integer>();
    private Stack<Integer> stack_2 = new Stack<Integer>();

    public void enqueue(int item) {
        stack_1.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return stack_2.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return stack_2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack_2.isEmpty())
            while (!stack_1.isEmpty())
                stack_2.push(stack_1.pop());
    }

    public boolean isEmpty() {
        return stack_1.isEmpty() && stack_2.isEmpty();
    }
}
