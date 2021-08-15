package com.smpaaark.programmers.coupang;

import java.util.HashMap;
import java.util.Map;

public class Q2 {

    public static void main(String[] args) {
        Q2 q = new Q2();
        System.out.println(q.solution(new int[]{-1, 0, 0, 1, 2, 2, 3, 3, 4, 5, 5}, 6, 9));
    }

    public int solution(int[] matches, int me, int opp) {
        // map에 matches의 값의 횟수를 저장합니다.
        // 여기서 값이 1인 값만 부전승인 값입니다.
        Map<Integer, Integer> map = new HashMap<>();
        for (int match : matches) {
            map.put(match, map.getOrDefault(match, 0) + 1);
        }

        int matchCount = 0;
        // me와 opp이 만날때까지 반복합니다.
        while (matches[me] != matches[opp]) {
            // 이때 me가 부전승인 경우 매치 횟수를 더하지 않습니다.
            if (map.get(matches[me]) > 1) {
                matchCount++;
            }

            // 다음 라운드로 변경합니다.
            me = matches[me];
            opp = matches[opp];
        }

        // 마지막으로 만나서 하는 경기 수까지 더해야 하므로 1을 더해서 리턴합니다.
        return matchCount + 1;
    }

}
