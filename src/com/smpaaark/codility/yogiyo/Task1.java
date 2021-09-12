package com.smpaaark.codility.yogiyo;

public class Task1 {

    public static void main(String[] args) {
        Task1 q = new Task1();
        System.out.println(q.solution(1));
    }

    public int solution(int N) {
        if (N < 10) {
            return 0;
        }

        int digit = (int)(Math.log10(N) + 1) - 1;

        int result = ((int) Math.pow(10, digit));


        return result;
    }

}
