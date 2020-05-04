package ch.brandon.hackerrank.medium;

import org.junit.Test;

import java.util.List;

import static ch.brandon.hackerrank.medium.NonDivisibleSubset.nonDivisibleSubset;
import static org.junit.Assert.assertEquals;

public class NonDivisibleSubsetTest {

    @Test
    public void testNonDivisibleSubset_1() {
        var init = List.of(1, 7, 2, 4);
        var actual = nonDivisibleSubset(3, init);
        assertEquals(3, actual);
    }

    @Test
    public void testNonDivisibleSubset_2() {
        var init = List.of(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);
        var actual = nonDivisibleSubset(7, init);
        assertEquals(11, actual);
    }
}