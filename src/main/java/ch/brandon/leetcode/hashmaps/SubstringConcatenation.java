package ch.brandon.leetcode.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsCount = countWords(words);

        int arrayLength = words.length;
        int wordLength = words[0].length();

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length() - (arrayLength * wordLength) + 1; i++) {
            String subString = s.substring(i, i + arrayLength * wordLength);
            if (countWordsFromString(subString, wordLength).equals(wordsCount)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    Map<String, Integer> countWordsFromString(String s, int stepSize) {
        if (s.length() % stepSize != 0) {
            System.out.println("Error in step size");
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += stepSize) {
            String word = s.substring(i, i + stepSize);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }


}
