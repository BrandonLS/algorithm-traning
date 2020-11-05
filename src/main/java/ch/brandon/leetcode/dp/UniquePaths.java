package ch.brandon.leetcode.dp;

/*
https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    /*
    using DP
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /*
    using combinations
     */
    public int uniquePathsComb(int m, int n) {
        // robot must go down m-1 times and right n-1 times.
        // This equates to a choose(n-1 + m-1, m-1)

        int smallestK = m < n ? m - 1 : n - 1;

        return nChooseK(n + m - 2, smallestK);
    }

    int nChooseK(int n, int k) {
        // https://en.wikipedia.org/wiki/Binomial_coefficient#Multiplicative_formula

        long product = 1L;
        for (int i = 1; i <= k; i++) {
            System.out.println("i : " + i + " product " + product);
            product = product * (n + 1 - i) / i;

        }
        return (int) product;
    }
}
