package ch.brandon.leetcode.hashmaps;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/*
https://leetcode.com/problems/my-calendar-i/
 */
public class MyCalendar {

    private NavigableMap<Integer, Integer> map = new TreeMap<>();

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);

        if (ceilingEntry != null && end > ceilingEntry.getKey()) {
            return false;
        }

        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }

        map.put(start, end);
        return true;
    }

}
