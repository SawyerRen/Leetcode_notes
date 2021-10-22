package company.facebook;

import model.TreeNode;

public class Q549 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int inc = 1, dec = 1;
        if (root.left != null) {
            int[] left = helper(root.left);
            if (root.left.val == root.val + 1) {
                inc = left[0] + 1;
            } else if (root.left.val == root.val - 1) {
                dec = left[1] + 1;
            }
        }
        if (root.right != null) {
            int[] right = helper(root.right);
            if (root.right.val == root.val + 1) {
                inc = Math.max(inc, right[0] + 1);
            } else if (root.right.val == root.val - 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }
        res = Math.max(res, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
