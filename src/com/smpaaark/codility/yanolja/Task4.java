package com.smpaaark.codility.yanolja;

public class Task4 {

    public static void main(String[] args) {
        Task4 q = new Task4();
        System.out.println(q.solution(new int[] {13, 7, 2, 8, 3}));
//        System.out.println(q.solution2(new int[] {13, 7, 2, 8, 3}));
    }

//    int result = 1;
//
//    public int solution2(int[] A) {
//        divideAndConquer(A, 0, A.length - 1);
//        return result;
//    }
//
//    private int[] divideAndConquer(int[] A, int start, int end) {
//        if (start >= end) {
//            return new int[] {1, A[start]};
//        }
//
//        int mid = start + (end - start) / 2;
//        int[] left = divideAndConquer(A, start, mid);
//        int[] right = divideAndConquer(A, mid + 1, end);
//
//        int midMax = divideAndConquerMid(A, start, mid, end);
//    }
//
//    private int divideAndConquerMid(int[] A, int start, int mid, int end) {
//
//
//    }

    boolean result = false;

    public int solution(int[] A) {
        // 최대 크기부터 순차적으로 계산
        for (int size = A.length; size > 0; size--) {
            // 확인할 size에 유효한 만큼만 초기값 계산
            for (int i = 0; i < A.length - size + 1; i++) {
                calculate(A, size, i, 1, A[i]);

                // result가 true가 되면 현재 검사한 size 리턴
                if (result) {
                    return size;
                }
            }
        }

        // 결과가 안나오면 임의로 -1 리턴
        return -1;
    }

    private void calculate(int[] A, int size, int index, int currentSize, int tempAnd) {
        // 중간 계산 결과가 0이면 더이상 계산할 필요 없으므로 리턴
        if (tempAnd == 0) {
            return;
        }

        // size가 현재 size와 같으면 결과 확인
        if (size == currentSize) {
            // 0보다 크면 result를 true로 변경한 후 리턴
            if (tempAnd > 0) {
                result = true;
            }

            return;
        }

        for (int i = index + 1; i < A.length; i++) {
            // 이미 결과가 나왔거나 남은 갯수가 size보다 작을 경우 리턴
            // 위 경우가 아닐 경우엔 계속 진행
            if (!result && A.length - i >= size - currentSize) {
                calculate(A, size, i, currentSize + 1, tempAnd & A[i]);
            } else {
                return;
            }
        }
    }

}
