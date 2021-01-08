package ch.brandon.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinimumPathSumTest {

    private MinimumPathSum subject = new MinimumPathSum();

    @Test
    public void minPathSumTest() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Assert.assertEquals(7, subject.minPathSum(grid));
    }
}