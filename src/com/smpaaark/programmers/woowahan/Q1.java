package com.smpaaark.programmers.woowahan;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {

    public static void main(String[] args) {
        Q1 q = new Q1();
        System.out.println(q.solution("ABCDEF"));
    }

    public String solution(String message) {
        Queue<Character> charQueue = new LinkedList<>();
        for (char c : message.toCharArray()) {
            charQueue.offer(c);
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        TreeNode rootNode = new TreeNode(charQueue.poll());
        treeQueue.offer(rootNode);

        while (!charQueue.isEmpty()) {
            TreeNode pollNode = treeQueue.poll();
            if (!charQueue.isEmpty()) {
                pollNode.left = new TreeNode(charQueue.poll());
                treeQueue.offer(pollNode.left);
            }

            if (!charQueue.isEmpty()) {
                pollNode.right = new TreeNode(charQueue.poll());
                treeQueue.offer(pollNode.right);
            }
        }

        StringBuilder result = new StringBuilder();
        postOrder(rootNode, result);
        return result.toString();
    }

    private void postOrder(TreeNode rootNode, StringBuilder result) {
        if (rootNode.left != null) {
            postOrder(rootNode.left, result);
        }

        if (rootNode.right != null) {
            postOrder(rootNode.right, result);
        }

        result.append(rootNode.val);
    }

    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }

    }

}
