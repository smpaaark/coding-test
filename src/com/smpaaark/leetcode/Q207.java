package com.smpaaark.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q207 {

    public static void main(String[] args) {
        Q207 q = new Q207();

        System.out.println(q.canFinish(2, new int[][]{{0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] courses = new int[numCourses][numCourses];
        int[] preCourseCount = new int[numCourses];

        for (int[] pre : prerequisites) {
            courses[pre[1]][pre[0]]++;
            preCourseCount[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int num : preCourseCount) {
            if (num == 0) {
                queue.offer(index);
            }
            index++;
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;

            index = 0;
            for (int num : courses[course]) {
                if (num > 0) {
                    preCourseCount[index]--;
                    if (preCourseCount[index] == 0) {
                        queue.offer(index);
                    }
                }
                index++;
            }
        }

        return numCourses == 0 ? true : false;
    }

}
