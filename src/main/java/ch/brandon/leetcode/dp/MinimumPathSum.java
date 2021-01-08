package ch.brandon.leetcode.dp;

/*
https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int gridValue = grid[i][j];
                int above = dp[i - 1][j];
                int left = dp[i][j - 1];
                dp[i][j] = gridValue + Math.min(above, left);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
