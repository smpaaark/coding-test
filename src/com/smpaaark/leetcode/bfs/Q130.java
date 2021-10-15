package com.smpaaark.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q130 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Q130 q = new Q130();
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        q.solve(board);
        System.out.println(Arrays.toString(board));
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m < 3 || n < 3) {
            return;
        }

        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    bfs(i, j, visit, board);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int xIndex, int yIndex, boolean[][] visit, char[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(xIndex, yIndex));
        visit[xIndex][yIndex] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempX = point.x + dx[i];
                int tempY = point.y + dy[i];
                if (tempX >= 0 && tempX < board.length && tempY >= 0 && tempY < board[0].length && board[tempX][tempY] == 'O' && !visit[tempX][tempY]) {
                    visit[tempX][tempY] = true;
                    queue.offer(new Point(tempX, tempY));
                }
            }
        }
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
