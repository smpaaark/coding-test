package com.smpaaark.leetcode.divideconquer;

public class Q105 {

    public static void main(String[] args) {
        Q105 q = new Q105();
        System.out.println(q.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preStartIndex, int inStartIndex, int inEndIndex, int[] preorder, int[] inorder) {
        if (preStartIndex > preorder.length - 1 || inStartIndex > inEndIndex) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStartIndex]);

        int inRootIndex = 0;
        for (int i = inStartIndex; i < inorder.length; i++) {
            if (inorder[i] == preorder[preStartIndex]) {
                inRootIndex = i;
            }
        }

        node.left = buildTree(preStartIndex + 1, inStartIndex, inRootIndex - 1, preorder, inorder);
        node.right = buildTree(preStartIndex + inRootIndex - inStartIndex + 1, inRootIndex + 1, inEndIndex, preorder, inorder);

        return node;
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

    }

}
