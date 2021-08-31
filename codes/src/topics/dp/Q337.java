package topics.dp;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337 {
    int res = Integer.MIN_VALUE;
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int robHere = root.val;
        if (root.left != null) robHere += helper(root.left.left) + helper(root.left.right);
        if (root.right != null) robHere += helper(root.right.left) + helper(root.right.right);
        int robNext = helper(root.left) + helper(root.right);
        res = Math.max(res, Math.max(robHere, robNext));
        memo.put(root, Math.max(robHere, robNext));
        return memo.get(root);
    }
}
