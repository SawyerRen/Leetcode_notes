package company.fbr4.q800;

import com.sun.source.tree.Tree;
import model.TreeNode;

public class Q897 {
    TreeNode head = null, tail = null;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (tail != null) {
            tail.right = root;
            root.left = null;
        } else {
            head = root;
        }
        tail = root;
        helper(root.right);
    }
}
