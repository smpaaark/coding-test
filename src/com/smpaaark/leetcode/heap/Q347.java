package com.smpaaark.leetcode.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] countArray = new ArrayList[nums.length + 1];
        for (int keyNum : map.keySet()) {
            int count = map.get(keyNum);
            if (countArray[count] == null) {
                countArray[count] = new ArrayList();
            }

            countArray[count].add(keyNum);
        }

        int[] result = new int[k];
        int kIndex = 0;
        for (int i = countArray.length - 1; i >= 0; i--) {
            if (countArray[i] != null) {
                for (int num : countArray[i]) {
                    result[kIndex++] = num;
                    if (kIndex == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

}
