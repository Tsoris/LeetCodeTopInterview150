package leetcode.binarytree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //post order solution

        //if node is found progate node up
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if a wanted node is a child of another node this path doesn't need to find the other one
        if(left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else {
            return left;
        }
    }
}
