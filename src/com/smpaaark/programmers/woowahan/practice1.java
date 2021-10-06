package com.smpaaark.programmers.woowahan;

import java.util.HashMap;
import java.util.Map;

public class practice1 {

    public int[] solution(int[][] v) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int[] array : v) {
            xMap.put(array[0], xMap.getOrDefault(array[0], 0) + 1);
            yMap.put(array[1], yMap.getOrDefault(array[1], 0) + 1);
        }

        int[] result = new int[2];
        for (int x : xMap.keySet()) {
            if (xMap.get(x) == 1) {
                result[0] = x;
            }
        }

        for (int y : yMap.keySet()) {
            if (yMap.get(y) == 1) {
                result[1] = y;
            }
        }

        return result;
    }

}
