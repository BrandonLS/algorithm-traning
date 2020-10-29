package ch.brandon.leetcode.dp;

public class UniqueBinaryTrees {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[i-j]*dp[j-1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
