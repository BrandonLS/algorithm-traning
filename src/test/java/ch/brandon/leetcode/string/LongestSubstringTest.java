package ch.brandon.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringTest {

    LongestSubstring subject = new LongestSubstring();

    @Test
    public void lengthOfLongestSubstringTest() {
        Assert.assertEquals(0, subject.lengthOfLongestSubstring(""));
        Assert.assertEquals(1, subject.lengthOfLongestSubstring("a"));
        Assert.assertEquals(3, subject.lengthOfLongestSubstring("aaaabbbbcd"));
    }



}