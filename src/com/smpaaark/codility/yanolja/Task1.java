package com.smpaaark.codility.yanolja;

import java.util.Arrays;
import java.util.Collections;

public class Task1 {

    public static void main(String[] args) {
        Task1 q = new Task1();
        System.out.println(q.solution(0));
    }

    /**
     * 입력된 정수 N의 각 자리수로 만들 수 있는 수 중에서 가장 큰수
     * 시간 복잡도: O(nlogn), 공간 복잡도: O(N의 길이)
     */
    public int solution(int N) {
        // N이 0이면 그대로 리턴
        if (N < 1) {
            return N;
        }

        // 정수 길이 계산
        int length = (int)(Math.log10(N)+1);

        // 내림차순 정렬을 위한 배열 생성
        Integer[] nums = new Integer[length];

        // 각 자리의 수를 nums 배열에 저장
        int index = 0;
        while (N > 0) { // O(N의 길이)
            int num = N % 10;
            nums[index++] = num;
            N /= 10;
        }

        // 내림차순 정렬
        Arrays.sort(nums, Collections.reverseOrder()); // O(nlogn)

        // 내림차순으로 정렬된 배열의 수를 정수로 계산
        int result = 0;
        for (int num : nums) { // O(N의 길이)
            result += num * Math.pow(10, length-- - 1);
        }

        return result;
    }

}
