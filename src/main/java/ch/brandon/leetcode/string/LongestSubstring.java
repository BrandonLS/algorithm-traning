package ch.brandon.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i + max < s.length() && j < s.length()) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                int currentMax = set.size();
                max = Math.max(max, currentMax);
                set = new HashSet<>();
                i++;
                j = i;
            } else {
                set.add(c);
                j++;
            }
        }
        max = Math.max(max, set.size());
        return max;
    }

}
