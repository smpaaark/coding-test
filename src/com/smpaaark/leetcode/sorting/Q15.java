package com.smpaaark.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int needNum = 0 - nums[i];

                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == needNum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum < needNum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

}
