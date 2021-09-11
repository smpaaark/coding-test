package com.smpaaark.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int low = 0;
        int high = 1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (high < s.length()) {
            if (set.contains(s.charAt(high))) {
                set.remove(s.charAt(low));
                low++;
            } else {
                set.add(s.charAt(high));
                high++;
                max = Math.max(max, set.size());
            }
        }

        return max;
    }

}
