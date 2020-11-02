package ch.brandon.leetcode.dp;

import java.util.Arrays;

public class CoinChange {

    /*
    iterative bottom up approach
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                if (dp[i - coin] < amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }


    /*
    recursive top down approach
     */
    public int coinChange2(int[] coins, int amount) {

        return coinChangeRec(coins, amount, new int[amount + 1]);
    }

    public Integer coinChangeRec(int[] coins, int remaining, int[] dp) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }
        if (dp[remaining] != 0) {
            return dp[remaining];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int value = coinChangeRec(coins, remaining - coins[i], dp);

            if (value >= 0 && value < min) {
                min = value + 1;
            }
        }

        dp[remaining] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[remaining];
    }

}