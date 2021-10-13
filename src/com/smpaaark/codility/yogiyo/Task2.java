package com.smpaaark.codility.yogiyo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        Task2 q = new Task2();
        System.out.println(q.solution(new int[] {6, 2, 3, 5, 6, 3}));
    }

    /**
     * 숫자 배열이 주어졌을때 1~최대값까지 1개씩 꽉 채워지게 하기 위해 이동해야 하는 횟수 구하기
     * O(n)
     * 개선할부분: ArrayList -> LinkedList로 변경
     * @param A
     * @return
     */
    public int solution(int[] A) {
        if (A.length == 1) {
            return 0;
        }

        int[] cache = new int[A.length + 1];
        for (int num : A) {
            cache[num]++;
        }

        List<Integer> zeroList = new LinkedList<>();
        List<Integer> duplicateList = new LinkedList<>();
        for (int i = 1; i < cache.length; i++) {
            if (cache[i] == 0) {
                zeroList.add(i);
            } else if (cache[i] > 1) {
                duplicateList.add(i);
            }
        }

        return move(cache, zeroList, duplicateList);
    }

    private int move(int[] cache, List<Integer> zeroList, List<Integer> duplicateList) {
        int move = 0;
        for (int num : zeroList) {
            int duplicateNum = duplicateList.get(0);
            move += Math.abs(duplicateNum - num);
            cache[duplicateNum]--;
            if (cache[duplicateNum] == 1) {
                duplicateList.remove(0);
            }
        }

        if (move > 1000000000) {
            return -1;
        }

        return move;
    }

}
