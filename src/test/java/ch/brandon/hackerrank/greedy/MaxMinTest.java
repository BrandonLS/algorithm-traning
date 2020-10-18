package ch.brandon.hackerrank.greedy;

import org.junit.Assert;
import org.junit.Test;

import static ch.brandon.hackerrank.greedy.MaxMin.maxMin;

public class MaxMinTest {

    @Test
    public void maxMinTest() {

        int[] arr = new int[]{1, 2, 3, 4};
        Assert.assertEquals(2, maxMin(2, arr));
    }
}