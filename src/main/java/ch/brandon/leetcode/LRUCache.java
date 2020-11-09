package ch.brandon.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    Map<Integer, Node> valueToNode = new HashMap<>();

    Node firstNode;
    Node lastNode;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.firstNode = new Node(-1, -1);
        this.lastNode = new Node(-1, -1);
        firstNode.next = lastNode;
        firstNode.previous = null;
        lastNode.previous = firstNode;
        lastNode.next = null;
    }

    // put item top of list
    public int get(int key) {
        if (!valueToNode.containsKey(key)) {
            return -1;
        }
        Node node = valueToNode.get(key);
        pushNodeToTop(node);
        return node.value;
    }

    // Put it in top of list
    // take out last one if capacity reached.
    public void put(int key, int value) {
        if (valueToNode.containsKey(key)) {
            Node n = valueToNode.get(key);
            n.value = value;
            pushNodeToTop(n);
            return;
        }

        if (valueToNode.size() >= capacity) {
            Node nodeToRemove = popLast();
            removeNode(nodeToRemove);
            valueToNode.remove(nodeToRemove.key);
        }
        Node newNode = new Node(key, value);
        insertNode(newNode);
        valueToNode.put(key, newNode);
    }

    private void pushNodeToTop(Node n) {
        removeNode(n);
        insertNode(n);
    }

    private void insertNode(Node n) {
        Node headNext = firstNode.next;
        firstNode.next = n;
        n.previous = firstNode;
        headNext.previous = n;
        n.next = headNext;
    }

    private Node popLast() {
        Node n = lastNode.previous;
        removeNode(n);
        return n;
    }

    private void removeNode(Node n) {
        n.previous.next = n.next;
        n.next.previous = n.previous;
    }

    private void printList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodes : ");
        sb.append("-1  ->");
        Node n = firstNode.next;
        while (n.value != -1 && n.next != null) {
            sb.append(n.key);
            sb.append("->");
            n = n.next;
        }
        sb.append("  -1");
        System.out.println(sb.toString());
    }

}
