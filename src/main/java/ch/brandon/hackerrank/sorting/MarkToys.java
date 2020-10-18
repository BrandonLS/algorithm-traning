package ch.brandon.hackerrank.sorting;

import java.util.Arrays;

public class MarkToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int currentMax = 0;
        int currentSum = 0;
        for(int i  = 0; i < prices.length; i++) {
            if(currentSum + prices[i] > k) {
                return currentMax;
            }
            currentMax++;
            currentSum += prices[i];
        }
        return currentMax;
    }
}
