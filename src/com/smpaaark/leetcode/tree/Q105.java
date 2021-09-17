package com.smpaaark.leetcode.tree;

public class Q105 {

    public static void main(String[] args) {
        Q105 q = new Q105();
        System.out.println(q.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solution(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode solution(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int findIndex = findIndex(inorder, inStart, inEnd, preorder[preStart]);

        root.left = solution(preorder, inorder, preStart + 1, inStart, findIndex - 1);
        root.right = solution(preorder, inorder, preStart + findIndex - inStart + 1, findIndex + 1, inEnd);

        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }

        return -1;
    }

    class TreeNode {

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

    }

}
