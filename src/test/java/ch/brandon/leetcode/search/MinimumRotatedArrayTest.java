package ch.brandon.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

public class MinimumRotatedArrayTest {

    private MinimumRotatedArray subject = new MinimumRotatedArray();

    @Test
    public void findMinTest() {

        Assert.assertEquals(0, subject.findMin(new int[]{7, 0, 1, 2, 3, 4, 5}));
        Assert.assertEquals(1, subject.findMin(new int[]{2, 3, 4, 5, 6, 7, 1}));
        Assert.assertEquals(1, subject.findMin(new int[]{1, 2}));
        Assert.assertEquals(0, subject.findMin(new int[]{4,5,6,7,0,1,2}));

    }
}