package com.smpaaark.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Q207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCoursesCount = new int[numCourses];
        int[][] preCoursesMatrix = new int[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            preCoursesMatrix[prerequisite[1]][prerequisite[0]]++;
            preCoursesCount[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        offerZeroCourse(preCoursesCount, queue);

        int completeCourse = getCompleteCourse(preCoursesCount, preCoursesMatrix, queue);

        return numCourses == completeCourse;
    }

    private int getCompleteCourse(int[] preCoursesCount, int[][] preCoursesMatrix, Queue<Integer> queue) {
        int completeCourse = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completeCourse++;
            updateMatrix(preCoursesCount, preCoursesMatrix, queue, course);
        }
        return completeCourse;
    }

    private void updateMatrix(int[] preCoursesCount, int[][] preCoursesMatrix, Queue<Integer> queue, int course) {
        for (int i = 0; i < preCoursesMatrix[course].length; i++) {
            checkCourse(preCoursesCount, preCoursesMatrix, queue, course, i);
        }
    }

    private void checkCourse(int[] preCoursesCount, int[][] preCoursesMatrix, Queue<Integer> queue, int course, int i) {
        if (preCoursesMatrix[course][i] > 0) {
            preCoursesMatrix[course][i]--;
            preCoursesCount[i]--;

            checkZero(preCoursesCount, queue, i);
        }
    }

    private void offerZeroCourse(int[] preCoursesCount, Queue<Integer> queue) {
        for (int i = 0; i < preCoursesCount.length; i++) {
            checkZero(preCoursesCount, queue, i);
        }
    }

    private void checkZero(int[] preCoursesCount, Queue<Integer> queue, int i) {
        if (preCoursesCount[i] == 0) {
            queue.offer(i);
        }
    }

}
