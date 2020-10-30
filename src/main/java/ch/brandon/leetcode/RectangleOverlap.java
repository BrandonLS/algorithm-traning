package ch.brandon.leetcode;

/*
https://leetcode.com/problems/rectangle-overlap/
 */
public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int u1 = rec2[0];
        int v1 = rec2[1];
        int u2 = rec2[2];
        int v2 = rec2[3];

        if (x1 == x2 || y1 == y2 || u1 == u2 || v1 == v2) {
            return false;
        }

        return !(u1 >= x2 || // right
                u2 <= x1 || // left
                v1 >= y2 || // higher
                v2 <= y1); // lower
    }

}
