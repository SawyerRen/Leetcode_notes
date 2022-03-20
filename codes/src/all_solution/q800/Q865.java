package all_solution.q800;

import model.TreeNode;

import java.util.TreeMap;

public class Q865 {
    int deepest = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private int helper(TreeNode root, int depth) {
        deepest = Math.max(depth, deepest);
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == deepest && right == deepest) {
            res = root;
        }
        return Math.max(left, right);
    }
}
