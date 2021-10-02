package com.smpaaark.programmers.woowahan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q4 {

    int differentCount = 0;
    int changeCount = 0;

    public static void main(String[] args) {
        Q4 q = new Q4();
        System.out.println(q.solution(new String[] {"A", "B", "C"}, new String[] {"B", "C", "A"}));
//        System.out.println(q.solution(new String[] {"A", "B", "C"}, new String[] {"D", "E", "C"}));
//        System.out.println(q.solution(new String[] {"A", "B", "C", "D"}, new String[] {"B", "Z", "D", "C"}));
    }

    public int solution(String[] before, String[] after) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < before.length; i++) {
            set.add(before[i]);
            if (!before[i].equals(after[i])) {
                differentCount++;
                map.put(after[i], i);
            }
        }

        if (differentCount == 0) {
            return 0;
        }

        for (int i = 0; i < before.length; i++) {
            String afterName = after[i];
            if (!before[i].equals(after[i]) && !set.contains(afterName)) {
                String beforeName = before[i];
                set.remove(beforeName);
                before[i] = afterName;
                changeCount++;
                differentCount--;
            }
        }

        while (differentCount > 0) {
            for (int i = 0; i < before.length; i++) {
                if (!before[i].equals(after[i])) {
                    changeName(i, map, set, before, after);
                }
            }
        }

        return changeCount;
    }

    private void changeName(int index, Map<String, Integer> map, Set<String> set, String[] before, String[] after) {
        String beforeName = before[index];
        String afterName = after[index];
        if (!set.contains(afterName)) {
            set.remove(beforeName);
            before[index] = afterName;
            changeCount++;
            differentCount--;
            return;
        }

        set.remove(beforeName);
        changeCount++;
        if (map.containsKey(beforeName)) {
            changeName(map.get(beforeName), map, set, before, after);
        }
    }

}
