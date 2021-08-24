package com.smpaaark.codility.yanolja;

import java.util.PriorityQueue;

public class Task3 {

    public static void main(String[] args) {
        Task3 q = new Task3();
        System.out.println("정답1: " + q.solution(new int[] {8, 8, 4, 3, 7, 9, 18, 8, 16, 8, 5, 79,51, 13, 5, 13,8, 89, 13, 2, 9}, 6));
        System.out.println("정답2: " + q.solution2(new int[] {8, 8, 4, 3, 7, 9, 18, 8, 16, 8, 5, 79,51, 13, 5, 13,8, 89, 13, 2, 9}, 6));
    }

    /**
     * 시간 복잡도: O(n^2), 공간 복잡도: O(n)
     */
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

    /**
     * 시간 복잡도: O(n), 공간 복잡도: O(n)
     */
    public int solution2(int[] A, int K) {
        // 최소값 초기화
        int result = Integer.MAX_VALUE;

        // max heap과 min heap 생성
        PriorityQueue<CustomNum> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.num - a.num;
        });
        PriorityQueue<CustomNum> minHeap = new PriorityQueue<>((a, b) -> {
            return a.num - b.num;
        });
        
        // K개를 제외한 앞에서부터 유효한 값들을 heap에 저장
        for (int i = 0; i < A.length - K; i++) {
            CustomNum num = new CustomNum(A[i], i);
            maxHeap.offer(num);
            minHeap.offer(num);
        }

        result = Math.min(result, maxHeap.peek().num - minHeap.peek().num);
        
        // 투포인터 사용
        int closeIndex = A.length - K - 2;
        int openIndex = A.length - 1;
        while (closeIndex >= 0) { // closeIndex가 0일때까지 반복

            // heap의 값이 현재 닫혀야하는 값이면 꺼낸다.
            while (maxHeap.peek().index > closeIndex && maxHeap.peek().index < openIndex) {
                maxHeap.poll();
            }
            while (minHeap.peek().index > closeIndex && minHeap.peek().index < openIndex) {
                minHeap.poll();
            }
            
            // 새로 open되는 값을 heap에 추가
            CustomNum num = new CustomNum(A[openIndex], openIndex);
            maxHeap.offer(num);
            minHeap.offer(num);
            
            // 결과 계산
            result = Math.min(result, maxHeap.peek().num - minHeap.peek().num);
            
            // 투 포인터 왼쪽으로 1칸 이동
            closeIndex--;
            openIndex--;
        }

        return result;
    }

    class CustomNum {

        int num;
        int index;

        public CustomNum(int num, int index) {
            this.num = num;
            this.index = index;
        }

    }

}
