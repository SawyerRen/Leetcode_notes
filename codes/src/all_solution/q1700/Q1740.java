package all_solution.q1700;

import model.TreeNode;

public class Q1740 {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode Lca = lca(root, p, q);
        return getDist(Lca, p, 0) + getDist(Lca, q, 0);
    }

    private int getDist(TreeNode root, int target, int dist) {
        if (root == null) return -1;
        if (root.val == target) {
            return dist;
        }
        int left = getDist(root.left, target, dist + 1);
        if (left >= 0) return left;
        return getDist(root.right, target, dist + 1);
    }

    private TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
