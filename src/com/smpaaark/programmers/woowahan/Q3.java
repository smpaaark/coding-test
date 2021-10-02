package com.smpaaark.programmers.woowahan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverseOrder;

public class Q3 {

    int minGap = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Q3 q = new Q3();
        System.out.println(q.solution(new int[][] {{100, 3}, {200, 1}, {50, 2}}));
        System.out.println(q.solution(new int[][] {{2500, 3}, {700, 5}}));
    }

    public int solution(int[][] money) {
        long start = System.currentTimeMillis();
        int sum = 0;
        List<Integer> moneyList = new ArrayList<>();
        for (int[] moneyPair : money) {
            sum += moneyPair[0] * moneyPair[1];
            for (int i = 0; i < moneyPair[1]; i++) {
                moneyList.add(moneyPair[0]);
            }
        }

        Collections.sort(moneyList, reverseOrder());
        backTracking(moneyList, 0, 0, sum, sum);

        System.out.println(System.currentTimeMillis() - start);
        return minGap;
    }

    private void backTracking(List<Integer> moneyList, int index, int firstMoney, int currentGap, int sum) {
        if (currentGap < minGap) {
            System.out.println("firstMoney = " + firstMoney + "m");
            minGap = currentGap;
        }

        for (int i = index; i < moneyList.size(); i++) {
            firstMoney += moneyList.get(i);
            int newGap = Math.abs((sum - firstMoney) - firstMoney);
            if (newGap > currentGap) {
                return;
            }

            backTracking(moneyList, i + 1, firstMoney, newGap, sum);
            firstMoney -= moneyList.get(i);
        }
    }

}
