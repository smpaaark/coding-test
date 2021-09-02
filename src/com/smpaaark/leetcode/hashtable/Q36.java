package com.smpaaark.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q36 {

    public static void main(String[] args) {
        Q36 q = new Q36();
        System.out.println(q.isValidSudoku(new char[][] {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            boxMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    Set<Character> rMap = rowMap.get(i);
                    if (rMap.contains(board[i][j])) {
                        return false;
                    } else {
                        rMap.add(board[i][j]);
                    }

                    Set<Character> cMap = colMap.get(j);
                    if (cMap.contains(board[i][j])) {
                        return false;
                    } else {
                        cMap.add(board[i][j]);
                    }
                    int boxNum = (3 * (i / 3)) + (j / 3);
                    Set<Character> bMap = boxMap.get(boxNum);
                    if (bMap.contains(board[i][j])) {
                        return false;
                    } else {
                        bMap.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

}
