package com.smpaaark.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solution(result, nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void solution(List<List<Integer>> result, int[] nums, ArrayList<Integer> list, boolean[] visit) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                list.add(nums[i]);
                visit[i] = true;
                solution(result, nums, list, visit);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
