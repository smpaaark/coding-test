package com.smpaaark.leetcode.dfs;

public class Q130 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int x, int y, char[][] board) {
        board[x][y] = '*';

        for (int i = 0; i < 4; i++) {
            int m = x + dx[i];
            int n = y + dy[i];
            if (m >= 0 && m < board.length && n >= 0 && n < board[m].length && board[m][n] == 'O') {
                board[m][n] = '*';
                dfs(m, n, board);
            }
        }
    }

}
