package com.smpaaark.leetcode.greedy;

public class Q122 {

    public int maxProfit(int[] prices) {
        int buy = -1;
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // 사는 경우
            if (buy < 0 && prices[i] < prices[i + 1]) {
                buy = i;
            } else if (buy > -1 && prices[i] > prices[i + 1]) { // 파는 경우
                sum += prices[i] - prices[buy];
                buy = -1;
            }
        }

        if (buy > -1) {
            sum += prices[prices.length - 1] - prices[buy];
        }

        return sum;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }

}
