package com.smpaaark.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int left = 0;
        int right = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int max = 1;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;

                max = Math.max(max, set.size());
            }
        }

        return max;
    }

}
