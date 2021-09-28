package com.smpaaark.leetcode.recursion;

import java.util.Stack;

public class Q394 {

    public static void main(String[] args) {
        Q394 q = new Q394();
        System.out.println(q.decodeString("abc3[cd]xyz"));
    }

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int index = 0;
        String tempStr = "";
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = 10 * num + (s.charAt(index) - '0');
                    index++;
                }

                intStack.push(num);
            } else if (c == '[') {
                strStack.push(tempStr);
                tempStr = "";
                index++;
            } else if (c == ']') {
                StringBuilder popStr = new StringBuilder(strStack.pop());
                int num = intStack.pop();
                while (num > 0) {
                    popStr.append(tempStr);
                    num--;
                }

                tempStr = popStr.toString();
                index++;
            } else {
                tempStr += c;
                index++;
            }
        }

        return tempStr;
    }

}
