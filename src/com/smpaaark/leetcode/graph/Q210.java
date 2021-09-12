package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] courseMatrix = new int[numCourses][numCourses];
        int[] courseCount = new int[numCourses];

        for (int[] pre : prerequisites) {
            courseMatrix[pre[1]][pre[0]]++;
            courseCount[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < courseCount.length; i++) {
            if (courseCount[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[resultIndex++] = course;

            for (int i = 0; i < courseMatrix[course].length; i++) {
                if (courseMatrix[course][i] > 0) {
                    courseCount[i]--;
                    if (courseCount[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return resultIndex == result.length ? result : new int[0];
    }

}
