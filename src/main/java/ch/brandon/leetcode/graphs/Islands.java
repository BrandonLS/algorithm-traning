package ch.brandon.leetcode.graphs;

/*
https://leetcode.com/problems/number-of-islands/
 */
public class Islands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        fillFalse(isVisited);

        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    markVisited(grid, isVisited, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    void markVisited(char[][] grid, boolean[][] isVisited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == '0' || isVisited[i][j]) {
            return;
        }

        isVisited[i][j] = true;
        markVisited(grid, isVisited, i + 1, j);
        markVisited(grid, isVisited, i, j + 1);
        markVisited(grid, isVisited, i - 1, j);
        markVisited(grid, isVisited, i, j - 1);
    }

    void fillFalse(boolean[][] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                isVisited[i][j] = false;
            }
        }
    }

}
