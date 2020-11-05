package ch.brandon.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    private UniquePaths subject = new UniquePaths();

    @Test
    public void nChooseKTest() {

        Assert.assertEquals(6, subject.nChooseK(4, 2));
        Assert.assertEquals(4, subject.nChooseK(4, 1));
        Assert.assertEquals(48620, subject.nChooseK(18, 9));
    }

    @Test
    public void uniquePathsTest() {
        Assert.assertEquals(6435, subject.uniquePaths(9, 8));
        Assert.assertEquals(557845, subject.uniquePaths(59, 5));
    }

    @Test
    public void uniquePathsCombTest() {
        Assert.assertEquals(6435, subject.uniquePathsComb(9, 8));
        Assert.assertEquals(557845, subject.uniquePathsComb(59, 5));
    }
}