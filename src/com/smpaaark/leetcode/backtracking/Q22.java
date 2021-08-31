package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesis(int n, int open, int close, String temp, List<String> result) {
        if (temp.length() == n  * 2) {
            result.add(temp);
            return;
        }

        if (open < n) {
            generateParenthesis(n, open + 1, close, temp + "(", result);
        }

        if (close < open) {
            generateParenthesis(n, open, close + 1, temp + ")", result);
        }
    }

}
