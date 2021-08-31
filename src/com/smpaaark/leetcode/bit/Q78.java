package com.smpaaark.leetcode.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q78 {

    public static void main(String[] args) {
        Q78 q = new Q78();
        System.out.println(q.subsets(new int[] {1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0)
                    subset.add(nums[j]);
            }
            Collections.sort(subset);
            subsets.add(subset);
        }
        return subsets;
    }

}
