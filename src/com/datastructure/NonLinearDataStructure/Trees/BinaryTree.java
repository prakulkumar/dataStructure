package com.datastructure.NonLinearDataStructure.Trees;

import java.util.ArrayList;

// Node(value, leftChild, rightChild)
public class BinaryTree {
    public class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;

        while (true) {
            if (current.value > value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }

                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }

                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;

        while (current != null) {
            if (current.value > value)
                current = current.leftChild;
            else if (current.value < value)
                current = current.rightChild;
            else
                return true;
        }

        return false;
    }

    /* *************** Tree Traversal *************** */

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    public void traverseInOrderAscending() {
        traverseInOrderAscending(root);
    }

    public void traverseInOrderDescending() {
        traverseInOrderDescending(root);
    }

    /*
     * root
     * leftChild
     * rightChild
     */
    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    /*
     * leftChild
     * rightChild
     * root
     */
    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    /*
     * leftChild
     * root
     * rightChild
     */
    private void traverseInOrderAscending(Node root) {
        if (root == null)
            return;

        traverseInOrderAscending(root.leftChild);
        System.out.println(root.value);
        traverseInOrderAscending(root.rightChild);
    }

    /*
     * rightChild
     * root
     * leftChild
     */
    private void traverseInOrderDescending(Node root) {
        if (root == null)
            return;

        traverseInOrderDescending(root.rightChild);
        System.out.println(root.value);
        traverseInOrderDescending(root.leftChild);
    }

    /* *************** Depth & Height *************** */
    public int height() {
        return height(root);
    }

    /* 1 + max(height(L), height(R)) */
    private int height(Node root) {
        if (root == null)
            return -1;

        if (haveNoLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    /* *************** Min & Max *************** */

    public int min() {
        return min(root);
    }

    public int max() {
        return max(root);
    }

    private int min(Node root) {
        if (haveNoLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private int max(Node root) {
        if (haveNoLeaf(root))
            return root.value;

        var left = max(root.leftChild);
        var right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    private boolean haveNoLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    /* *************** Equality Check *************** */

    public boolean equals(BinaryTree other) {
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value &&
                    equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild);

        return false;
    }

    /* *************** Validate Binary Search Tree *************** */

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min && root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    /* *************** Print Kth Node *************** */

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    /* *************** Level Order Traversal *************** */

    public void levelOrderTraversal() {
        for (int i = 0; i < height(); i++) {
            for (var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }
}
