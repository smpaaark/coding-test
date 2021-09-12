package com.smpaaark.leetcode.heap;

import java.util.*;

public class Q347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] countArray = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (countArray[value] == null) {
                countArray[value] = new ArrayList();
            }

            countArray[value].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = countArray.length - 1; i > 0; i--) {
            if (countArray[i] != null) {
                for (int num : countArray[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return null;
    }

}
