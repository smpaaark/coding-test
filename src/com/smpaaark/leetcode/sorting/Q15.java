package com.smpaaark.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {

    public static void main(String[] args) {
        Q15 q = new Q15();
        System.out.println(q.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]){
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int target = 0 - (nums[i] + nums[left]);
                    if (nums[right] == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        while (left + 1 < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (right - 1 > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }

}
