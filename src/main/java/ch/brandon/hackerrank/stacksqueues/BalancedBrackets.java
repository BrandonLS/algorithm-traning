package ch.brandon.hackerrank.stacksqueues;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        HashMap<Character, Character> openingToCloseBrackets = new HashMap<>();
        openingToCloseBrackets.put('(', ')');
        openingToCloseBrackets.put('[', ']');
        openingToCloseBrackets.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (openingToCloseBrackets.containsKey(currentChar)) {
                stack.push(currentChar);
            } else {
                if(stack.isEmpty()) {
                    return "NO";
                }
                if (openingToCloseBrackets.get(stack.pop()) != currentChar) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}
