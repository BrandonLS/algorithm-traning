package ch.brandon.leetcode.stackqueue;

import org.junit.Assert;
import org.junit.Test;

public class ReversePolishNotationTest {

    private ReversePolishNotation subject = new ReversePolishNotation();

    @Test
    public void readTest() {

        Assert.assertEquals(6, subject.evalRPN(new String[] {"4","13","5","/","+"}));
        Assert.assertEquals(22, subject.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}