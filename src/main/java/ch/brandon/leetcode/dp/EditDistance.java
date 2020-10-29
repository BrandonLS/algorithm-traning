package ch.brandon.leetcode.dp;

/*
https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int rows = word1.length();
        int cols = word2.length();

        int[][] cost = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows + 1; i++) {
            cost[i][0] = i;
        }
        for (int i = 0; i < cols + 1; i++) {
            cost[0][i] = i;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(word1.charAt(row) == word2.charAt(col)) {
                    cost[row + 1][col + 1] = cost[row][col];
                } else {
                    int a = cost[row][col];
                    int b = cost[row][col + 1];
                    int c = cost[row + 1][col];
                    cost[row + 1][col + 1] = Math.min(a, Math.min(b, c)) + 1;
                }
            }
        }
        return cost[rows][cols];
    }

}
