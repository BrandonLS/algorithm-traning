package ch.brandon.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepthNaryTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node n : root.children) {
            int currentDepth = maxDepth(n);
            if (currentDepth > max) {
                max = currentDepth;
            }
        }
        return max + 1;
    }

    public int maxDepth_Iterative(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {

            for(int i = 0; i < queue.size(); i++) {
                Node currentNode = queue.poll();
                for(Node n: currentNode.children) {
                    queue.add(n);
                }
            }

            depth++;
        }
        return depth;
    }

}
