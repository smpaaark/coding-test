package com.smpaaark.leetcode.greedy;

public class Q11 {

    public int maxArea(int[] height) {
        int maxResult = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int tempResult = (rightIndex - leftIndex) * (Math.min(height[leftIndex], height[rightIndex]));
            maxResult = Math.max(maxResult, tempResult);
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxResult;
    }

}
