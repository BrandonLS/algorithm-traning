package ch.brandon.leetcode.search;

import org.junit.Assert;
import org.junit.Test;

public class SquareRootTest {

    SquareRoot subject = new SquareRoot();

    @Test
    public void mySqrtTest() {
        Assert.assertEquals(2, subject.mySqrt(8));
        Assert.assertEquals(1, subject.mySqrt(1));
        Assert.assertEquals(0, subject.mySqrt(0));
    }

}