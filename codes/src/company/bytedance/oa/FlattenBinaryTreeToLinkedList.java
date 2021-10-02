package company.bytedance.oa;

import model.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        if (cur == null) return;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode left = cur.left;
                while (left.right != null) {
                    left = left.right;
                }
                left.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
