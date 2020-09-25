package ch.brandon.hackerrank.sorting;

import org.junit.Assert;
import org.junit.Test;

import static ch.brandon.hackerrank.sorting.FraudulentActivity.activityNotifications;
import static ch.brandon.hackerrank.sorting.FraudulentActivity.getMedian;

public class FraudulentActivityTest {

    @Test
    public void getMedianTest() {
        int[] data = new int[]{1, 2, 3, 4, 5};
        int[] data2 = new int[]{1, 2, 3, 4};

        Assert.assertEquals(3, getMedian(data, 5), 0.01);
        Assert.assertEquals(2.5, getMedian(data2, 5), 0.01);
    }

    @Test
    public void activityNotificationstest() {
        int[] data = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        int[] data2 = new int[]{1, 2, 3, 4, 4};
        Assert.assertEquals(2, activityNotifications(data, 5));
        Assert.assertEquals(0, activityNotifications(data2, 4));
    }

}
