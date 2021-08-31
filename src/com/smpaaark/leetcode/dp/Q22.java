package com.smpaaark.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q22 {

    public static void main(String[] args) {
        Q22 q = new Q22();
        System.out.println(q.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<List<String>> dpList = new ArrayList<>();
        List<String> init = Arrays.asList("");
        dpList.add(init);

        for (int i = 1; i <= n; i++) {
            List<String> newList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> innerList = dpList.get(j);
                List<String> tailList = dpList.get(i - j - 1);

                for (int in = 0; in < innerList.size(); in++) {
                    for (int ta = 0; ta < tailList.size(); ta++) {
                        newList.add("(" + innerList.get(in) + ")" + tailList.get(ta));
                    }
                }
            }

            dpList.add(newList);
        }

        return dpList.get(n);
    }

}
