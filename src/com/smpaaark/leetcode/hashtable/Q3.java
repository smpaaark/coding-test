package com.smpaaark.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    private int maxLength = 0;
    private int rightIndex = 0;
    private int leftIndex = 0;

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        Set<Character> set = new HashSet<>();
        solution(s, set);

        maxLength = Math.max(maxLength, set.size());

        return maxLength;
    }

    private void solution(String s, Set<Character> set) {
        while (rightIndex < s.length()) {
            checkRightIndexCharacter(s, set);
        }
    }

    private void checkRightIndexCharacter(String s, Set<Character> set) {
        if (set.contains(s.charAt(rightIndex))) {
            maxLength = Math.max(maxLength, set.size());
            set.remove(s.charAt(leftIndex));
            leftIndex++;
            return;
        }

        set.add(s.charAt(rightIndex));
        rightIndex++;
    }

}
