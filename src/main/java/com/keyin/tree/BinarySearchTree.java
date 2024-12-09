package com.keyin.tree;

class BinarySearchTree {
    private int value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public void insert(int number) {
        if (number < value) {
            if (left == null) {
                left = new BinarySearchTree(number);
            } else {
                left.insert(number);
            }
        } else {
            if (right == null) {
                right = new BinarySearchTree(number);
            } else {
                right.insert(number);
            }
        }
    }

    @Override
    public String toString() {
        String leftStr = (left != null) ? left.toString() : "null";
        String rightStr = (right != null) ? right.toString() : "null";
//        return "{ \"value\": " + value + ", \"left\": " + leftStr + ", \"right\": " + rightStr + " }";
        return String.format("{\"value\":%d,\"left\":%s,\"right\":%s}", value, leftStr, rightStr);
    }
}
