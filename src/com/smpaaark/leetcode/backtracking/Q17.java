package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q17 {

    final String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) {
            letterCombinations(digits, result, 0, "");
        }

        return result;
    }

    private void letterCombinations(String digits, List<String> result, int index, String tempLetter) {
        if (digits.length() == tempLetter.length()) {
            result.add(tempLetter);
            return;
        }

        String strNumber = digits.substring(index, index + 1);
        int number = Integer.parseInt(strNumber);
        for (int i = 0; i < letters[number].length(); i++) {
            letterCombinations(digits, result, index + 1, tempLetter + letters[number].substring(i, i + 1));
        }
    }

}
