package com.smpaaark.codility.yogiyo;

import java.util.HashSet;
import java.util.Set;

public class DemoTask1 {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }

        int result = 1;
        while (result <= Integer.MAX_VALUE) {
            if (!set.contains(result)) {
                return result;
            }

            result++;
        }

        return -1;
    }

}
