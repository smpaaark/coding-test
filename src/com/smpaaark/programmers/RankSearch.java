package com.smpaaark.programmers;

import java.util.*;

public class RankSearch {

    public static void main(String[] args) {
        RankSearch q = new RankSearch();
        System.out.println(q.solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}));
    }

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();

        // Map에 모든 경우의 수 저장
        for (String str : info) {
            settingMap(map, str.split(" "), 0, 0, "");
        }

        // 점수 오름차순 정렬
        for (List<Integer> score : map.values()) {
            Collections.sort(score);
        }

        int[] result = new int[query.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = findQueryCount(query[i], map);
        }

        return result;
    }

    private int findQueryCount(String query, Map<String, List<Integer>> map) {
        String[] splitQuery = query.split(" and ");
        String[] splitQuery2 = query.split(" ");
        String condition = splitQuery[0] + splitQuery[1] + splitQuery[2] + splitQuery2[splitQuery2.length - 2];
        int score = Integer.parseInt(splitQuery2[splitQuery2.length - 1]);

        if (map.containsKey(condition)) {
            return binarySearch(map.get(condition), score);
        }

        return 0;
    }

    private int binarySearch(List<Integer> list, int score) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= score) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return list.size() - start;
    }

    private void settingMap(Map<String, List<Integer>> map, String[] info, int index, int depth, String tempStr) {
        if (depth == 4) {
            List<Integer> scoreList = map.containsKey(tempStr) ? map.get(tempStr) : new ArrayList<>();
            scoreList.add(Integer.parseInt(info[index]));
            map.put(tempStr, scoreList);

            return;
        }

        settingMap(map, info, index + 1, depth + 1, tempStr + info[index]);
        settingMap(map, info, index + 1, depth + 1, tempStr + "-");
    }

}
