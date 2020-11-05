package ch.brandon.leetcode.search;

/*
https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid <= x / mid) {
                left = mid + 1; // + 1 just an optimization since we checked that mid wasn't the answer already.
            } else {
                right = mid + 1;
            }
        }
        return x;
    }
}
