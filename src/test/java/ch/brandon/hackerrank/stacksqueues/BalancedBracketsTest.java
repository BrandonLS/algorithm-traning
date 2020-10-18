package ch.brandon.hackerrank.stacksqueues;

import org.junit.Assert;

import static ch.brandon.hackerrank.stacksqueues.BalancedBrackets.isBalanced;

public class BalancedBracketsTest {

    public void isBalancedTest_0() {
        String s1 = "}][}}(}][))]";
        Assert.assertEquals("NO", isBalanced(s1));
    }

}