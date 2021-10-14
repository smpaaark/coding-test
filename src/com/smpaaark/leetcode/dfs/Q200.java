package com.smpaaark.leetcode.dfs;

public class Q200 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if (tempX >= 0 && tempX < grid.length && tempY >= 0 && tempY < grid[0].length && grid[tempX][tempY] == '1') {
                dfs(tempX, tempY, grid);
            }
        }
    }
}
