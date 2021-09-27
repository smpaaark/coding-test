package com.smpaaark.leetcode.hashtable;

import java.util.*;

public class Q49 {

    public static void main(String[] args) {
        Q49 q = new Q49();
        System.out.println(q.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] alphabet = new char[26];
            for (char c : str.toCharArray()) {
                alphabet[c - 'a']++;
            }
            String key = String.valueOf(alphabet);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

}
