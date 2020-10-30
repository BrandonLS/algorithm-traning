package ch.brandon.leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

/*
    A better solution could be created using binary search
 */
public class kSmallestSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int counter = 0;
        int[] array = new int[n + m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[counter] = matrix[i][j];
                counter++;
            }
        }

        Arrays.sort(array);
        return array[k];
    }
}
