package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {
    public int kThSmallest(TreeNode root, int k) {
        List<Integer> treeVals = new ArrayList<>();

        inOrderTraversal(root, treeVals);

        return treeVals.get(k - 1);
    }

    private void inOrderTraversal(TreeNode root, List<Integer> treeVals) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, treeVals);
        treeVals.add(root.val);
        inOrderTraversal(root.right, treeVals);
    }
}
