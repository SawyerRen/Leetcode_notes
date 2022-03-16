package all_solution.q600;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q671 {
    Integer res = null;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        helper(root, root.val);
        return res == null ? -1 : res;
    }

    private void helper(TreeNode root, int rootVal) {
        if (root == null) return;
        if (root.val > rootVal) res = res == null ? root.val : Math.min(res, root.val);
        helper(root.left, rootVal);
        helper(root.right, rootVal);
    }
}
