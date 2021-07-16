package topics.tree;

import model.TreeNode;

public class Q250 {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            res++;
            return true;
        }
        boolean uniVal = true;
        if (root.left != null) {
            uniVal = helper(root.left) && root.val == root.left.val;
        }
        if (root.right != null) {
            uniVal = helper(root.right) && root.val == root.right.val;
        }
        if (uniVal) {
            res++;
            return true;
        }
        return false;
    }
}
