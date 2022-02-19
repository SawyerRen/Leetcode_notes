package all_solution.q200;

import model.TreeNode;

public class Q250 {
    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    private boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        boolean uniVal = true;
        if (!left || (root.left != null && root.left.val != root.val)) uniVal = false;
        if (!right || root.right != null && root.right.val != root.val) uniVal = false;
        if (uniVal) count++;
        return uniVal;
    }
}
