package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q227 {

    public static void main(String[] args) {
        Q227 q = new Q227();
        System.out.println(q.calculate("3+2*2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = (num * 10) + Integer.parseInt(String.valueOf(c));
            } else if (c != ' '){
                calculate(stack, num, sign);
                sign = c;
                num = 0;
            }
        }

        calculate(stack, num, sign);

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private void calculate(Stack<Integer> stack, int num, char sign) {
        switch (sign) {
            case '+':
                stack.push(num);
                break;
            case '-':
                stack.push(-num);
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
        }
    }

}
