package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }

        int[][] matrix = new int[numCourses][numCourses];
        int[] count = new int[numCourses];

        for (int[] pre : prerequisites) {
            matrix[pre[1]][pre[0]]++;
            count[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        int remainCourse = numCourses;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            remainCourse--;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] > 0) {
                    count[i]--;
                    if (count[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return remainCourse == 0 ? true : false;
    }

}
