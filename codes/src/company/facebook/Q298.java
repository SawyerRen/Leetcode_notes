package company.facebook;

import model.TreeNode;

public class Q298 {
    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, root.val - 1, 0);
        return maxLen;
    }

    private void helper(TreeNode root, int preVal, int len) {
        if (root == null) return;
        if (root.val == preVal + 1) {
            len++;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
        helper(root.left, root.val, len);
        helper(root.right, root.val, len);
    }
}
