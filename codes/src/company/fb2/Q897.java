package company.fb2;

import model.TreeNode;

import java.util.concurrent.TimeUnit;

public class Q897 {
    TreeNode head = null;
    TreeNode tail = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        increasingBST(root.left);
        if (tail != null) {
            tail.right = root;
            root.left = null;
        } else {
            head = root;
        }
        tail = root;
        increasingBST(root.right);
        return head;
    }
}
