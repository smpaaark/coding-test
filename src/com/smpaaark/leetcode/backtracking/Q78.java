package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q78 {

    public static void main(String[] args) {
        Q78 q = new Q78();
        System.out.println(q.subsets(new int[] {1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        solution(nums, result, 0, list);

        return result;
    }

    private void solution(int[] nums, List<List<Integer>> result, int index, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            solution(nums, result, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
