package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q227 {

    public static void main(String[] args) {
        Q227 q = new Q227();
        System.out.println(q.calculate("3+2*2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char currentOperator = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = (currentNumber * 10) + (c - '0');
            } else if ((!Character.isDigit(c) && c != ' ')){
                calculate(stack, currentNumber, currentOperator);
                currentOperator = c;
                currentNumber = 0;
            }
        }

        calculate(stack, currentNumber, currentOperator);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private void calculate(Stack<Integer> stack, int currentNumber, char currentOperator) {
        if (currentOperator == '+') {
            stack.push(currentNumber);
        } else if (currentOperator == '-') {
            stack.push(-currentNumber);
        } else if (currentOperator == '*') {
            stack.push(stack.pop() * currentNumber);
        } else if (currentOperator == '/') {
            stack.push(stack.pop() / currentNumber);
        }
    }

}
