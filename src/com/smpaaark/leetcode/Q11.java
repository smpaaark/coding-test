package com.smpaaark.leetcode;

public class Q11 {

    public int maxArea(int[] height) {
        int max = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            max = Math.max(max, (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]));

            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return max;
    }

}
