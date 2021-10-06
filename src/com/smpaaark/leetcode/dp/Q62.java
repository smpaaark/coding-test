package com.smpaaark.leetcode.dp;

public class Q62 {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            calculate(n, matrix, i);
        }
        return matrix[m - 1][n - 1];
    }

    private void calculate(int n, int[][] matrix, int i) {
        for (int j = 0; j < n; j++) {
            calculate(matrix, i, j);
        }
    }

    private void calculate(int[][] matrix, int i, int j) {
        if (i == 0 || j == 0) {
            matrix[i][j] = 1;
            return;
        }
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
    }
}
