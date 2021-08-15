package com.smpaaark.codility.yanolja;

import java.util.Arrays;
import java.util.Collections;

public class Task1 {

    public static void main(String[] args) {
        Task1 q = new Task1();
        System.out.println(q.solution(0));
    }

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
        while (N > 0) {
            int num = N % 10;
            nums[index++] = num;
            N /= 10;
        }

        // 내림차순 정렬
        Arrays.sort(nums, Collections.reverseOrder());

        // 내림차순으로 정렬된 배열의 수를 정수로 계산
        int result = 0;
        for (int num : nums) {
            result += num * Math.pow(10, length-- - 1);
        }

        return result;
    }

}
