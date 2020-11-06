package ch.brandon.leetcode.hashmaps;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarTest {

    private MyCalendar subject = new MyCalendar();

    @Test
    public void bookTest() {
        Assert.assertEquals(true, subject.book(10, 20));
        Assert.assertEquals(false, subject.book(5, 15));
        Assert.assertEquals(false, subject.book(15, 25));
        Assert.assertEquals(true, subject.book(5, 7));
        Assert.assertEquals(true, subject.book(23, 25));
        Assert.assertEquals(true, subject.book(25, 26));

        Assert.assertEquals(false, subject.book(15, 21));
        Assert.assertEquals(false, subject.book(21, 24));
    }
}