package com.smpaaark.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int firstIndex = 0; firstIndex < nums.length - 2; firstIndex++) {
            if (firstIndex == 0 || (nums[firstIndex] != nums[firstIndex - 1])) {
                int secondIndex = firstIndex + 1;
                int thirdIndex = nums.length - 1;
                while (secondIndex < thirdIndex) {
                    int needNum = 0 - (nums[firstIndex] + nums[secondIndex]);
                    if (nums[thirdIndex] == needNum) {
                        result.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[thirdIndex]));

                        while (secondIndex < thirdIndex && nums[secondIndex] == nums[secondIndex + 1]) {
                            secondIndex++;
                        }

                        while (secondIndex < thirdIndex && nums[thirdIndex] == nums[thirdIndex - 1]) {
                            thirdIndex--;
                        }

                        secondIndex++;
                        thirdIndex--;
                    } else if (nums[thirdIndex] > needNum) {
                        thirdIndex--;
                    } else {
                        secondIndex++;
                    }
                }
            }
        }

        return result;
    }

}
