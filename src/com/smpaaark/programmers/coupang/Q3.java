package com.smpaaark.programmers.coupang;

public class Q3 {

    public int solution(String p, String s) {
        // 결과로 반화할 변수
        int countSum = 0;

        for (int i = 0; i < p.length(); i++) {
            // 각 자리 수를 정수로 변환합니다.
            int pNum = p.charAt(i) - '0';
            int sNum = s.charAt(i) -'0';

            // 더 큰값과 작은값을 구분합니다.
            int max = Math.max(pNum, sNum);
            int min = Math.min(pNum, sNum);

            // 큰값 - 작은값을 계산합니다.
            int count = max - min;

            // 계산한 값이 5보다 클 경우 반대 방향으로 돌리는 것이 더 적은 횟수로 맞출 수 있습니다.
            if (count > 5) {
                // 작은 값에 10을 더한뒤 큰값을 빼주면 반대방향으로 돌리는 횟수입니다.
                count = min + 10 - max;
            }

            // 결과값에 값을 누적시킵니다.
            countSum += count;
        }

        // 결과를 반환합니다.
        return countSum;
    }

}
