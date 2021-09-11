package com.smpaaark.leetcode.stack;

import java.util.Stack;

public class Q227 {

    public static void main(String[] args) {
        Q227 q = new Q227();
        System.out.println(q.calculate("3+2*2"));
    }

    public int calculate(String s) {
        if (s.length() == 1) {
            return Character.getNumericValue(s.charAt(0));
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = (num * 10) + Character.getNumericValue(c);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (operation) {
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
                }

                operation = c;
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

}
