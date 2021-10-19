package company.facebook;

import model.TreeNode;

public class Q333 {
    public int largestBSTSubtree(TreeNode root) {
        int[] res = helper(root);
        return res[2];
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if (root.val > left[1] && root.val < right[0]) {
            return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val),
                    left[2] + right[2] + 1};
        } else {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
