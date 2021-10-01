package com.smpaaark.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length -1;
        }

        return null;
    }

}
