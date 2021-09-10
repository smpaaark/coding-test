package com.smpaaark.leetcode.tree;

public class Q98 {

    public static void main(String[] args) {
        Q98 q = new Q98();
        TreeNode root = new TreeNode(2147483647);
        System.out.println(q.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return solution(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean solution(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        return solution(root.left, minValue, root.val) && solution(root.right, root.val, maxValue);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
