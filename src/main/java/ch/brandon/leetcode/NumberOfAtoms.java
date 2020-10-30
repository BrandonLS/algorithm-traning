package ch.brandon.leetcode;

import java.util.*;

/*
https://leetcode.com/problems/number-of-atoms/

Horrible spaghetti code, but it works.

 */
public class NumberOfAtoms {

    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        while (!formula.isEmpty()) {

            char currentChar = formula.charAt(0);

            if (formula.length() == 1 && Character.isAlphabetic(currentChar)) {
                String atom = Character.toString(currentChar);
                Map<String, Integer> currentMap = stack.peek();
                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + 1);
                return printMap(currentMap);
            }

            if (currentChar == '(') {
                formula = formula.substring(1);
                stack.push(new HashMap<>());

            } else if (currentChar == ')') {
                formula = formula.substring(1);
                if (formula.isEmpty()) {
                    return printMap(stack.peek());
                }
                char followingChar = formula.charAt(0);
                Map<String, Integer> tempMap = stack.pop();
                int count;
                if (Character.isDigit(followingChar)) {

                    String numberAsString = "";
                    while (!formula.isEmpty() && Character.isDigit(formula.charAt(0))) {
                        numberAsString += formula.charAt(0);
                        formula = formula.substring(1);
                    }
                    count = Integer.parseInt(numberAsString);
                } else {
                    count = 1;
                }
                Map<String, Integer> currentMap = stack.peek();
                for (var e : tempMap.entrySet()) {
                    String atomName = e.getKey();
                    int value = tempMap.get(atomName) * count;
                    currentMap.put(atomName, currentMap.getOrDefault(atomName, 0) + value);
                }
            } else if (Character.isUpperCase(formula.charAt(1)) || formula.charAt(1) == ')' || formula.charAt(1) == '(') {
                Map<String, Integer> currentMap = stack.peek();
                String atomName = Character.toString(currentChar);
                currentMap.put(atomName, currentMap.getOrDefault(atomName, 0) + 1);
                formula = formula.substring(1);

            } else if (Character.isDigit(formula.charAt(1))) {
                String atom = Character.toString(currentChar);
                formula = formula.substring(1);

                String numberAsString = "";
                while (!formula.isEmpty() && Character.isDigit(formula.charAt(0))) {
                    numberAsString += formula.charAt(0);
                    formula = formula.substring(1);
                }

                int count = Integer.parseInt(numberAsString);
                Map<String, Integer> currentMap = stack.peek();
                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);

            } else if (Character.isLowerCase(formula.charAt(1))) {
                String atomName = "" + currentChar + formula.charAt(1);
                formula = formula.substring(2);
                if (formula.isEmpty()) {
                    Map<String, Integer> currentMap = stack.peek();
                    currentMap.put(atomName, currentMap.getOrDefault(atomName, 0) + 1);
                    return printMap(currentMap);
                }

                char followingChar = formula.charAt(0);
                Map<String, Integer> currentMap = stack.peek();
                if (Character.isDigit(followingChar)) {
                    String numberAsString = "";
                    while (!formula.isEmpty() && Character.isDigit(formula.charAt(0))) {
                        numberAsString += formula.charAt(0);
                        formula = formula.substring(1);
                    }
                    int count = Integer.parseInt(numberAsString);
                    currentMap.put(atomName, currentMap.getOrDefault(atomName, 0) + count);
                } else {
                    currentMap.put(atomName, currentMap.getOrDefault(atomName, 0) + 1);
                }
            }
        }

        return printMap(stack);
    }

    private String printMap(Stack<Map<String, Integer>> stack) {
        if (stack.size() != 1) {
            System.out.println("Problem, stack should be one");
        }
        return printMap(stack.pop());
    }

    private String printMap(Map<String, Integer> map) {
        String s = "";
        for (var e : map.entrySet()) {
            if (e.getValue() == 1) {
                s += e.getKey();
            } else {
                s += e.getKey() + e.getValue();
            }
        }
        return s;
    }

}
