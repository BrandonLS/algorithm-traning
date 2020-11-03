package ch.brandon.leetcode.string;

/*
https://leetcode.com/problems/add-binary/
 */
public class BinarySum {

    public String addBinary(String a, String b) {

        String aReverse = new StringBuilder(a).reverse().toString();
        String bReverse = new StringBuilder(b).reverse().toString();
        int n = Math.max(a.length(), b.length());
        StringBuilder sumBuilder = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < n; i++) {
            int elemA = i >= aReverse.length() ? 0 : Integer.parseInt("" + aReverse.charAt(i));
            int elemB = i >= bReverse.length() ? 0 : Integer.parseInt("" + bReverse.charAt(i));

            int sum = elemA + elemB + carry;
            if (sum < 2) {
                sumBuilder.append(sum);
                carry = 0;
            } else {
                sumBuilder.append(sum % 2);
                carry = 1;
            }
        }
        if (carry != 0) {
            sumBuilder.append(1);
        }
        return sumBuilder.reverse().toString();
    }

}
