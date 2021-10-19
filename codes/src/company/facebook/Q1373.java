package company.facebook;

import model.TreeNode;

public class Q1373 {
    int res = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return res;
    }

    class Result {
        int lower;
        int higher;
        int sum;

        public Result(int lower, int higher, int sum) {
            this.lower = lower;
            this.higher = higher;
            this.sum = sum;
        }
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left == null || right == null) return null;
        if (root.val <= left.higher || root.val >= right.lower) return null;
        int sum = left.sum + right.sum + root.val;
        res = Math.max(res, sum);
        return new Result(Math.min(left.lower, root.val), Math.max(right.higher, root.val), sum);
    }
}
