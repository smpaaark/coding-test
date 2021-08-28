package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int rightNum = 0;
            int leftNum = 0;
            switch (token) {
                case "+":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum + rightNum);
                    break;
                case "-":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum - rightNum);
                    break;
                case "*":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum * rightNum);
                    break;
                case "/":
                    rightNum = stack.pop();
                    leftNum = stack.pop();
                    stack.push(leftNum / rightNum);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
