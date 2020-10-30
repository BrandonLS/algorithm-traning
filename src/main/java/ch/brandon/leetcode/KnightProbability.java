package ch.brandon.leetcode;

/*
https://leetcode.com/problems/knight-probability-in-chessboard/
 */
public class KnightProbability {

    public double knightProbability(int N, int K, int r, int c) {

        int[][] directions = new int[][]{
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        double[][][] positionProb = new double[K + 1][N][N]; // can optimize with smaller array
        positionProb[0][r][c] = 1.0;

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : directions) {
                        int oldRow = i - d[0];
                        int oldCol = j - d[1];
                        if (oldRow >= 0 && oldCol >= 0 && oldRow < N && oldCol < N) {
                            positionProb[k][i][j] += (positionProb[k - 1][oldRow][oldCol] / 8.0);
                        }
                    }
                }
            }
        }

        // Add up all array
        double totalProb = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalProb += positionProb[K][i][j];
            }
        }
        return totalProb;
    }
}
