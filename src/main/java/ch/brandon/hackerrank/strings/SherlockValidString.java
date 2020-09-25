package ch.brandon.hackerrank.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> countByChar = count(s);
        List<Integer> counts = new ArrayList<>(countByChar.values());

        return areAllElementsButOneSame(counts) ? "YES" : "NO";

    }

    static HashMap<Character, Integer> count(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        return countMap;
    }

    static boolean areAllElementsButOneSame(List<Integer> list) {
        if (list.size() == 1) {
            return true;
        }
        if (list.size() == 2) {
            return Math.abs(list.get(0) - list.get(1)) <= 1;
        }
        else {
            // find target count
            int first = list.get(0);
            int second = list.get(1);
            int third = list.get(2);

            // if all three different always false
            if (first != second && first != third && second != third) {
                return false;
            }

            int target = -1;
            if(first == second || first == third) {
                target = first;
            } else  {
                target = second;
            }

            return areElementsEqualOrOneOffTarget(list, target);
        }
    }

    static boolean areElementsEqualOrOneOffTarget(List<Integer> list, int target) {
        int offTarget = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != target) {
                offTarget++;
                if(offTarget > 1) {
                    return false;
                }
                if(list.get(i) - target > 1) {
                    return false;
                }
                if(list.get(i) < target && list.get(i) != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}