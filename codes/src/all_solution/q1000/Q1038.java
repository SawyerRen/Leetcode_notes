package all_solution.q1000;

import model.TreeNode;

public class Q1038 {
    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        pre += root.val;
        root.val = pre;
        helper(root.left);
    }
}
