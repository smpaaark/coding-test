package com.smpaaark.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17 {

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        letterCombinations(result, digits, map, 0, "");
        return result;
    }

    private void letterCombinations(List<String> result, String digits, Map<Integer, String> map, int index, String tempLetter) {
        if (digits.length() == tempLetter.length()) {
            result.add(tempLetter);
            return;
        }

        int number = Integer.parseInt(digits.substring(index, index + 1));
        for (char c : map.get(number).toCharArray()) {
            letterCombinations(result, digits, map, index + 1, tempLetter + c);
        }
    }

}
