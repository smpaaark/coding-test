package com.smpaaark.leetcode.array;

public class Q11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int horizontal = right - left;
            int vertical = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, horizontal * vertical);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] >= height[right]) {
                right--;
            }
        }

        return maxArea;
    }

}