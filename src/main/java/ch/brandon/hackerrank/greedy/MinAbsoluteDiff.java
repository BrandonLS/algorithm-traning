package ch.brandon.hackerrank.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MinAbsoluteDiff {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        List<Integer> listFull = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>(new HashSet<>(listFull));

        if (list.size() != listFull.size()) {
            return 0;
        }

        list.sort(Integer::compareTo);

        int min = Math.abs(list.get(0) - list.get(1));
        for (int i = 1; i < list.size() - 1; i++) {
            int currentMin = Math.abs(list.get(i) - list.get(i + 1));
            if (currentMin < min) {
                min = currentMin;
            }
        }

        return min;
    }


}