package all_solution.q1300;

import model.TreeNode;

public class Q1339 {
    long res = 0, total = 0;

    public int maxProduct(TreeNode root) {
        total = helper(root);
        helper(root);
        return (int) (res % (1e9 + 7));
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int sum = helper(root.left) + helper(root.right) + root.val;
        res = Math.max(res, (total - sum) * sum);
        return sum;
    }
}
