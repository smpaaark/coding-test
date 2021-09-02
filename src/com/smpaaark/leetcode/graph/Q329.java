package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q329 {

    int max = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Q329 q = new Q329();
//        System.out.println(q.longestIncreasingPath(new int[][] {{7,8,9},{9,7,6},{7,2,3}}));
        System.out.println(q.longestIncreasingPath2(new int[][] {{9, 9, 4},{6, 6, 8},{2, 1, 1}}));
        System.out.println(q.longestIncreasingPath2(new int[][] {{7,8,9},{9,7,6},{7,2,3}}));
    }

    public int longestIncreasingPath2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(i, j, m, n, matrix, cache);
                max = Math.max(max, len);
            }
        }

        return max;
    }

    private int dfs(int i, int j, int m, int n, int[][] matrix, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }

        int max = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(x, y, m, n, matrix, cache);
                max = Math.max(max, len);
            }
        }

        cache[i][j] = max;
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 0) {
                    solution(i, j, count, matrix);
                }
            }
        }

        return max;
    }

    private void solution(int x, int y, int[][] count, int[][] matrix) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count[point.x][point.y] = point.count;
            max = Math.max(max, point.count);
            int nextCount = point.count + 1;

            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];
                if (tempX >= 0 && tempY >= 0 && tempX < matrix.length && tempY < matrix[0].length && matrix[tempX][tempY] > matrix[point.x][point.y] && nextCount > count[tempX][tempY]) {
                    queue.offer(new Point(tempX, tempY, nextCount));
                    count[tempX][tempY] = nextCount;
                }
            }
        }
    }

    class Point {

        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

}
