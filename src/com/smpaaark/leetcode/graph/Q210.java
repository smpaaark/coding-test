package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preCount = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];

        for (int[] array : prerequisites) {
            preCount[array[0]]++;
            matrix[array[1]][array[0]] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCount.length; i++) {
            if (preCount[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[resultIndex++] = course;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] > 0) {
                    preCount[i]--;
                    if (preCount[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return resultIndex == numCourses ? result : new int[0];
    }

}
