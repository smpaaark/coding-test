package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, n, 0, 0, "");

        return result;
    }

    private void generateParenthesis(List<String> result, int n, int open, int close, String tempStr) {
        if (tempStr.length() == n * 2) {
            result.add(tempStr);
            return;
        }

        if (open < n) {
            generateParenthesis(result, n, open + 1, close, tempStr + "(");
        }

        if (close < open) {
            generateParenthesis(result, n, open, close + 1, tempStr + ")");
        }
    }

}
