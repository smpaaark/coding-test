package com.smpaaark.codility.yanolja;

public class Task4 {

    public static void main(String[] args) {
        Task4 q = new Task4();
        System.out.println(q.solution(new int[] {7, 1, 9, 1,2, 3, 7}));
        System.out.println(q.solution2(new int[] {7, 1, 9, 1,2, 3, 7}));
    }

    int result2 = 0;

    public int solution2(int[] A) {
        for (int i = 0; i < A.length; i++) { // O(n)
            if (A.length - i > result2) { // 현재 남은 수가 최대값보다 클 때만 진행
                calculate2(A, i + 1, 1, A[i], A[i] + "");
            }
        }

        return result2;
    }

    private void calculate2(int[] A, int index, int currentSize, int tempAnd, String checkStr) {
        // max 값 저장
        result2 = Math.max(result2, currentSize);

        for (int i = index; i < A.length; i++) {
            if (currentSize + A.length - i > result2) { // 현재 남은 수가 최대값보다 클 때만 진행
                int andNum = tempAnd & A[i];
                if (andNum != 0) {
                    calculate2(A, i + 1, currentSize + 1, andNum, checkStr + " " + A[i]);
                }
            } else {
                return;
            }
        }
    }

// =================================================================================

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
