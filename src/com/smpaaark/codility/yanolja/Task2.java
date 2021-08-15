package com.smpaaark.codility.yanolja;

public class Task2 {

    int min = 0;

    public static void main(String[] args) {
        Task2 q = new Task2();
        System.out.println(q.solution(0));
    }

    public int solution(int N) {
        // N이 한자리 수이면 그대로 리턴
        if (N < 10) {
            return N;
        }

        // 9로 나눈 몫을 저장
        int nineSize = N / 9;

        // 9로 채울 수를 초기화
        int nineNum = 0;

        // while문에 쓰일 nineSize 복사
        int loopSize = nineSize;

        // nineSize 길이의 9로 채워진 수를 구한다
        while (loopSize > 0) {
            nineNum += 9 * Math.pow(10, loopSize-- - 1);
        }

        // 제일 앞자리 수는 N에서 9 * ninesize를 뺀 값이다.
        int firstNum = N - (9 * nineSize);

        return (int) (firstNum * Math.pow(10, nineSize) + nineNum);
    }


}
