package ch.brandon.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {


    @Test
    public void putAndGetTest() {
        LRUCache subject = new LRUCache(2);
        subject.put(1, 3);
        subject.put(2, 2);

        Assert.assertEquals(-1, subject.get(6));
        Assert.assertEquals(3, subject.get(1));
        Assert.assertEquals(2, subject.get(2));

        subject.put(6, 6);
        Assert.assertEquals(6, subject.get(6));
        Assert.assertEquals(-1, subject.get(1));

        subject.put(2, 5);
    }

}