package ch.brandon.hackerrank.greedy;

import java.util.Arrays;

class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - k + 1; i++) {
            int[] subArr = Arrays.copyOfRange(arr, i, i + k);
            int first = subArr[0];
            int last = subArr[subArr.length - 1];
            System.out.println("Testing array " + Arrays.toString(subArr));
            int currentMin = Math.abs(first - last);
            if (currentMin < min) {
                min = currentMin;
            }
        }
        return min;
    }


}
