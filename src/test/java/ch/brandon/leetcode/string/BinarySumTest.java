package ch.brandon.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySumTest {

    private BinarySum subject = new BinarySum();

    @Test
    public void sumTest() {
        Assert.assertEquals("11", subject.addBinary("10", "1"));
        Assert.assertEquals("111", subject.addBinary("111", "0"));
        Assert.assertEquals("1000", subject.addBinary("111", "1"));
        Assert.assertEquals("1110", subject.addBinary("111", "111"));
        Assert.assertEquals("111", subject.addBinary("101", "10"));

    }

}