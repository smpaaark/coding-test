package com.smpaaark.leetcode.heap;

import java.util.PriorityQueue;

public class Q378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < n; i++) {
            heap.offer(new Point(0, i, matrix[0][i]));
        }

        while (k-- > 1) {
            Point point = heap.poll();
            if (point.x + 1 < n) {
                heap.offer(new Point(point.x + 1, point.y, matrix[point.x + 1][point.y]));
            }
        }

        return heap.poll().val;
    }

    class Point {

        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

    }

}
