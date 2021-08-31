package com.smpaaark.leetcode.sorting;

import java.util.*;

public class Q49 {

    public static void main(String[] args) {
        String st = "eat";
        char[] chars = st.toCharArray();
        Arrays.sort(chars);
        System.out.println(String.valueOf(chars));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

}
