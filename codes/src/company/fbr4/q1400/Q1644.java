package company.fbr4.q1400;

import com.sun.source.tree.Tree;
import model.TreeNode;

public class Q1644 {
    int found = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        if (found == 2) return res;
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (root == p || root == q) {
            found++;
            return root;
        }
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
