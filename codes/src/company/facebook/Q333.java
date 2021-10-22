package company.facebook;

import model.TreeNode;

public class Q333 {
    class Result {
        int minVal;
        int maxVal;
        int size;

        public Result(int minVal, int maxVal, int size) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result res = helper(root);
        return res.size;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (root.val <= left.maxVal || root.val >= right.minVal) {
            return new Result(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
        } else {
            return new Result(Math.min(left.minVal, root.val), Math.max(right.maxVal, root.val),
                    left.size + right.size + 1);
        }
    }
}
