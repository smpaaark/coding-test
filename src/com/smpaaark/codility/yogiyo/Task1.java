package com.smpaaark.codility.yogiyo;

public class Task1 {

    public static void main(String[] args) {
        Task1 q = new Task1();
        System.out.println(q.solution(9999));
    }

    /**
     * 정수 N이 주어지면 N과 같은 길이로 표현할 수 있는 가장 작은 수 출력
     * O(1)
     * @param N
     * @return
     */
    public int solution(int N) {
        if (N < 10) {
            return 0;
        }

        int digit = (int)(Math.log10(N) + 1) - 1;

        int result = ((int) Math.pow(10, digit));


        return result;
    }

}
