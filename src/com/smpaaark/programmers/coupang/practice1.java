package com.smpaaark.programmers.coupang;

import java.util.HashMap;
import java.util.Map;

public class practice1 {

    public static void main(String[] args) {
        practice1 q = new practice1();
        System.out.println(q.solution(new int[][] {{1, 4}, {3, 4}, {3, 10}}));
    }

    public int[] solution(int[][] v) {
        int x = 0;
        int y = 0;
        for (int[] point : v) {
            x ^= point[0];
            y ^= point[1];
        }

        int[] result = new int[2];
        result[0] = x;
        result[1] = y;

        return result;
    }

}
