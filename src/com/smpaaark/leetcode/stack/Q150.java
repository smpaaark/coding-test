package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            solution(stack, token);
        }

        return stack.pop();
    }

    private void solution(Stack<Integer> stack, String token) {
        if ("+".equals(token)) {
            int num1 = stack.pop();
            int num2 = stack.pop();
            stack.push(num1 + num2);

            return;
        } else if ("-".equals(token)) {
            int num2 = stack.pop();
            int num1 = stack.pop();
            stack.push(num1 - num2);

            return;
        } else if ("*".equals(token)) {
            int num1 = stack.pop();
            int num2 = stack.pop();
            stack.push(num1 * num2);

            return;
        } else if ("/".equals(token)) {
            int num2 = stack.pop();
            int num1 = stack.pop();
            stack.push(num1 / num2);

            return;
        }

        stack.push(Integer.parseInt(token));
    }

}
