package com.smpaaark.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int leftIndex = 0;
        int currentIndex = 0;
        int max = 0;
        while (currentIndex < s.length()) {
            if (!set.contains(s.charAt(currentIndex))) {
                set.add(s.charAt(currentIndex++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(leftIndex++));
            }
        }

        return max;
    }

}
