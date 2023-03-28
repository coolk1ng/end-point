package com.coolk1ng.algorithm.example;

import org.springframework.util.CollectionUtils;

import java.util.Stack;

/**
 * 实现一个栈，该栈带有出栈（pop）、入栈（push）、取最小元素（getMin）3 个方法。要保证这3个方法的时间复杂度都是O(1)。
 *
 * @author coolk1ng
 * @since 2023/3/20 13:45
 */
public class MinStack {
    private final Stack<Integer> mainStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int element)
    {
        mainStack.push(element);

        // 辅助栈为空或者比之前的小时, push
        if (CollectionUtils.isEmpty(minStack) || element < minStack.peek())
        {
            minStack.push(element);
        }
    }

    public int pop()
    {
        if (mainStack.peek().equals(minStack.peek()))
        {
            minStack.pop();
        }

        return mainStack.pop();
    }

    public int getMin() throws Exception
    {
        if (CollectionUtils.isEmpty(mainStack))
        {
            throw new Exception("mainStack is empty!");
        }

        return minStack.peek();
    }

    public static void main(String[] args) throws Exception
    {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(4);
        System.out.println(stack.getMin());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }
}
