package all_solution.q400;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q404 {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) res += root.left.val;
        helper(root.left);
        helper(root.right);
    }
}
