package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q150 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int rightNumMul = stack.pop();
                    int leftNumMul = stack.pop();
                    stack.push(leftNumMul - rightNumMul);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int rightNumDiv = stack.pop();
                    int leftNumDiv = stack.pop();
                    stack.push(leftNumDiv / rightNumDiv);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }

}
