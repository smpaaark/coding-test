package com.smpaaark.leetcode.binarysearch;

public class Q240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mIndex = 0;
        int nIndex = matrix[mIndex].length - 1;
        while (mIndex < matrix.length && nIndex >= 0) {
            if (matrix[mIndex][nIndex] == target) {
                return true;
            }
            if (matrix[mIndex][nIndex] < target) {
                mIndex++;
            } else {
                nIndex--;
            }
        }
        return false;
    }
}
