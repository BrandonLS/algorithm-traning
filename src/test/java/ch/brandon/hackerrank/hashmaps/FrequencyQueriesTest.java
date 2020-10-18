package ch.brandon.hackerrank.hashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static ch.brandon.hackerrank.hashmaps.FrequencyQueries.freqQuery;

public class FrequencyQueriesTest {

    @Test
    public void freqQueryEmpty() {

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(3, 5));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(0), actual);
    }

    @Test
    public void freqQueryTest_AddQueryRight() {

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 1));
        queries.add(List.of(3, 1));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(1), actual);
    }

    @Test
    public void freqQueryTest_AddQueryNotThere() {

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 1));
        queries.add(List.of(3, 2));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(0), actual);
    }

    @Test
    public void freqQueryTest_AddDeletePresentNotThere() {

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 1));
        queries.add(List.of(2, 1));
        queries.add(List.of(3, 1));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(0), actual);
    }

    @Test
    public void freqQueryTest_AddMultipleDeleteOne_Present() {

        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 1));
        queries.add(List.of(1, 1));
        queries.add(List.of(1, 1));
        queries.add(List.of(2, 1));

        queries.add(List.of(3, 1));
        queries.add(List.of(3, 2));
        queries.add(List.of(3, 3));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(0, 1, 0), actual);
    }

    @Test
    public void freqQueryTest_Ex2() {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1, 3));
        queries.add(List.of(2, 3));
        queries.add(List.of(3, 2));
        queries.add(List.of(1, 4));
        queries.add(List.of(1, 5));
        queries.add(List.of(1, 5));
        queries.add(List.of(1, 4));
        queries.add(List.of(3, 2));
        queries.add(List.of(2, 4));
        queries.add(List.of(3, 2));

        var actual = freqQuery(queries);
        Assert.assertEquals(List.of(0, 1, 1), actual);

    }
}