package ch.brandon.hackerrank.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> countByNumber = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for (List<Integer> q : queries) {
            int instruction = q.get(0);
            int value = q.get(1);

            System.out.println("normal count " + countByNumber.toString());
            System.out.println("freq count " + frequencyCount.toString());
            System.out.println("----");

            switch (instruction) {
                case 1: {
                    int frequency = countByNumber.getOrDefault(value, 0);
                    countByNumber.put(value, frequency + 1);
                    frequencyCount.put(frequency, frequencyCount.getOrDefault(frequency, 0) - 1);
                    frequencyCount.put(frequency + 1, frequencyCount.getOrDefault(frequency + 1, 0) + 1);
                    break;
                }

                case 2:
                    if (!countByNumber.containsKey(value)) {
                        break;
                    }
                    if (countByNumber.get(value) == 1) {
                        countByNumber.remove(value);
                        frequencyCount.put(1, frequencyCount.getOrDefault(1, 0) - 1);

                    } else {
                        int frequency = countByNumber.getOrDefault(value, 0);
                        countByNumber.put(value, frequency - 1);
                        frequencyCount.put(frequency, frequencyCount.getOrDefault(frequency, 0) - 1);
                        frequencyCount.put(frequency - 1, frequencyCount.getOrDefault(frequency - 1, 0) + 1);
                    }
                    break;

                case 3:
                    if (frequencyCount.getOrDefault(value, 0) > 0) {
                        answer.add(1);
                    } else {
                        answer.add(0);
                    }
                    break;
            }

        }
        return answer;
    }

    // 1 x = add x
    // 2 y = delete y
    // 3 z = Check if any integer is present whose frequency is exactly z

}
