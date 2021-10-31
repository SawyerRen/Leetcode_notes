package company.fbr3;

import model.TreeNode;

public class Q1373 {
    class Result {
        int min;
        int max;
        int sum;

        public Result(int min, int max, int sum) {
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int res = 0;

    public int maxSumBST(TreeNode root) {
        Result result = helper(root);
        return res;
    }

    private Result helper(TreeNode root) {
        if (root == null)
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left.max >= root.val || right.min <= root.val) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
        } else {
            int max = Math.max(right.max, root.val);
            int min = Math.min(left.min, root.val);
            int sum = left.sum + root.val + right.sum;
            res = Math.max(res, sum);
            return new Result(min, max, sum);
        }
    }
}
