package leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time: O(n); Auxiliary space: O(h), excluding O(n) result storage.
    // n = traversed nodes, h = height; recursion stack and values grouped by level.
    public List<List<Integer>> depthFirstTraversalLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        depthFirstTraverseLevel(root, 0, result);

        return result;
    }

    // Time: O(n); Auxiliary space: O(h), excluding O(n) result storage.
    // n = traversed nodes, h = height; recursion stack and values grouped by level.
    public void depthFirstTraverseLevel(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);

        depthFirstTraverseLevel(root.left, level + 1, result);
        depthFirstTraverseLevel(root.right, level + 1, result);
    }

    // Time: O(n); Auxiliary space: O(w), excluding O(n) output.
    // n = nodes, w = maximum width; queue holds portions of at most two levels.
    public List<List<Integer>> breathFirstTraversalLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.addLast(root);

        while (!nodes.isEmpty()) {
            int nodeLevelCount = nodes.size();
            ArrayList<Integer> currLevelVals = new ArrayList<>();

            for (int i = 0; i < nodeLevelCount; i++) {
                TreeNode currNode = nodes.removeFirst();
                currLevelVals.add(currNode.val);

                TreeNode left = currNode.left;
                TreeNode right = currNode.right;

                if (left != null) {
                    nodes.addLast(left);
                }
                if (right != null) {
                    nodes.addLast(right);
                }
            }
            result.add(currLevelVals);
        }

        return result;
    }
}
