package com.smpaaark.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int result = 0;
        while (rightIndex < s.length()) {
            char c = s.charAt(rightIndex);
            if (set.contains(c)) {
                set.remove(s.charAt(leftIndex++));
            } else {
                set.add(c);
                result = Math.max(result, set.size());
                rightIndex++;
            }
        }

        return result;
    }

}
