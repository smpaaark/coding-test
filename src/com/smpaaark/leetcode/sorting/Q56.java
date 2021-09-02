package com.smpaaark.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {

    public static void main(String[] args) {
        Q56 q = new Q56();
        System.out.println(q.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 1;
        int[] array = intervals[0];
        while (i < intervals.length) {
            if (array[1] >= intervals[i][0]) {
                if (array[1] <= intervals[i][1]) {
                    array[1] = intervals[i][1];
                }

                i++;
            } else {
                list.add(array);
                array = intervals[i];
            }
        }

        if (array != null) {
            list.add(array);
        }

        return list.toArray(new int[list.size()][2]);
    }

}
