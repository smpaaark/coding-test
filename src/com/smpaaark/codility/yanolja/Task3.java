package com.smpaaark.codility.yanolja;

import java.util.PriorityQueue;

public class Task3 {

    public static void main(String[] args) {
        Task3 q = new Task3();
        System.out.println(q.solution(new int[] {8, 8, 4, 3}, 2));
    }

    public int solution(int[] A, int K) {
        // 최소값 초기화
        int min = Integer.MAX_VALUE;

        // 연속 부분 집합 순차적으로 계산
        for (int i = 0; i < A.length - K + 1; i++) {
            // max heap과 min heap 생성
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // A의 수를 모두 heap에 담는데 제외할 연속 부분 집합은 heap에 추가하지 않는다
            for (int j = 0; j < A.length; j++) {
                if (j < i || j > i + K - 1) {
                    maxHeap.offer(A[j]);
                    minHeap.offer(A[j]);
                }
            }

            // 최소값을 구한다.
            min = Math.min(maxHeap.poll() - minHeap.poll(), min);
        }

        return min;
    }

}
