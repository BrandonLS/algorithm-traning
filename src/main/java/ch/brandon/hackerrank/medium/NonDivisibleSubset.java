package ch.brandon.hackerrank.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of hanker rank exercise https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
class NonDivisibleSubset {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */
     static int nonDivisibleSubset(int k, List<Integer> s) {
        List<Integer> remainders = getRemainders(k, s);
        Map<Integer, Integer> countByElem = countByElem(remainders);
        int maxSize = 0;
        for (int r : possibleRemainders(k / 2 + 1)) {
            int complementary = k - r;
            if (!countByElem.containsKey(r) && !countByElem.containsKey(complementary)) {
                continue;
            }

            if (r == 0) { // if the remainder is 0, we can only add the element once
                maxSize += 1;
            } else if (r == complementary) { // if the remainder = its complementary, we can only add one elem
                maxSize += 1;
            }
            // we can't have a set of numbers with remainder and their complementary counterpart, choose the biggest set
            else {
                if (countByElem.getOrDefault(r, 0) > countByElem.getOrDefault(complementary, 0)) {
                    maxSize += countByElem.get(r);
                } else {
                    maxSize += countByElem.get(complementary);
                }
            }
        }
        return maxSize;
    }

    private static List<Integer> getRemainders(int k, List<Integer> list) {
        return list.stream().map(l -> l % k).collect(Collectors.toList());
    }

    private static List<Integer> possibleRemainders(int k) {
        List<Integer> possibleRemainders = new ArrayList<>();
        int i = 0;
        while (i < k) {
            possibleRemainders.add(i);
            i++;
        }
        return possibleRemainders;
    }

    private static Map<Integer, Integer> countByElem(List<Integer> list) {
        Map<Integer, Integer> countByInt = new HashMap<>();

        for (int elem : list) {
            if (countByInt.containsKey(elem)) {
                countByInt.put(elem, countByInt.get(elem) + 1);
            } else {
                countByInt.put(elem, 1);
            }
        }
        return countByInt;
    }
}
