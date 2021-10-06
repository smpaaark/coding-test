package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preCourseCountArray = new int[numCourses];
        int[][] courseMatrix = new int[numCourses][numCourses];

        for (int[] pre : prerequisites) {
            preCourseCountArray[pre[0]]++;
            courseMatrix[pre[1]][pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCourseCountArray.length; i++) {
            if (preCourseCountArray[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int resultIndex = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[resultIndex] = course;
            resultIndex++;

            for (int i = 0; i < courseMatrix[course].length; i++) {
                if (courseMatrix[course][i] > 0) {
                    preCourseCountArray[i]--;
                    if (preCourseCountArray[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        if (resultIndex == numCourses) {
            return result;
        }

        return new int[0];
    }

}
