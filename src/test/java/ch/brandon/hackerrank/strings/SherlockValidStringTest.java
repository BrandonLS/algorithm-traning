package ch.brandon.hackerrank.strings;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static ch.brandon.hackerrank.strings.SherlockValidString.areElementsEqualOrOneOffTarget;
import static ch.brandon.hackerrank.strings.SherlockValidString.isValid;

public class SherlockValidStringTest {

    @Test
    public void areElementsEqualOrOneOffTargetTest() {
        Assert.assertTrue(areElementsEqualOrOneOffTarget(List.of(2, 2, 2, 2), 2));
        Assert.assertFalse(areElementsEqualOrOneOffTarget(List.of(1, 2, 2, 2), 2));
        Assert.assertTrue(areElementsEqualOrOneOffTarget(List.of(3, 2, 2, 2), 2));
        Assert.assertFalse(areElementsEqualOrOneOffTarget(List.of(1, 2, 2, 1), 2));
        Assert.assertFalse(areElementsEqualOrOneOffTarget(List.of(1, 2, 2, 2), 1));
        Assert.assertFalse(areElementsEqualOrOneOffTarget(List.of(4, 2, 2, 2), 2));

    }

    @Test
    public void testCase1() {
        Assert.assertEquals("NO", isValid("aabbcd"));
    }

    @Test
    public void testCase4() {
        Assert.assertEquals("YES", isValid("aabbc"));
    }

}