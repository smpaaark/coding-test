package com.smpaaark.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            levelOrder(result, queue);
        }

        return result;
    }

    private void levelOrder(List<List<Integer>> result, Queue<TreeNode> queue) {
        int queueSize = queue.size();
        List<Integer> innerList = new ArrayList<>();
        while (queueSize > 0) {
            queueSize = levelOrder(queue, queueSize, innerList);
        }

        result.add(innerList);
    }

    private int levelOrder(Queue<TreeNode> queue, int queueSize, List<Integer> innerList) {
        TreeNode pollNode = queue.poll();
        innerList.add(pollNode.val);

        if (pollNode.left != null) {
            queue.offer(pollNode.left);
        }

        if (pollNode.right != null) {
            queue.offer(pollNode.right);
        }

        queueSize--;
        return queueSize;
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
