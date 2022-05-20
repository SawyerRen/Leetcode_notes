package all_solution.q2000;

import model.TreeNode;

import java.util.TreeMap;

public class Q2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root, startValue, destValue);
        StringBuilder builder = new StringBuilder();
        helper(lca, startValue, true, builder);
        helper(lca, destValue, false, builder);
        return builder.toString();
    }

    private boolean helper(TreeNode root, int target, boolean isStart, StringBuilder builder) {
        if (root == null) return false;
        if (root.val == target) return true;
        builder.append(isStart ? "U" : "L");
        if (helper(root.left, target, isStart, builder)) return true;
        builder.setLength(builder.length() - 1);
        builder.append(isStart ? "U" : "R");
        if (helper(root.right, target, isStart, builder)) return true;
        builder.setLength(builder.length() - 1);
        return false;
    }

    private TreeNode findLca(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
