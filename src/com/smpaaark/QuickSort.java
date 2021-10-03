package com.smpaaark;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {9, 5, 4, 3, 1, 7, 2, 6, 8};
        solution(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void solution(int[] array, int low, int high) {
        if (low > high) {
            return;
        }

        int pivot = low;

        for (int i = low; i < high; i++) {
            if (array[i] < array[high]) {
                swap(array, pivot, i);
                pivot++;
            }
        }

        swap(array, pivot, high);
        solution(array, low, pivot - 1);
        solution(array, pivot + 1, high);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
