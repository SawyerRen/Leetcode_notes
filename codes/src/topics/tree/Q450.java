package topics.tree;

import model.TreeNode;

public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) {
                root = root.right;
                return root;
            }
            if (root.right == null) {
                root = root.left;
                return root;
            }
            TreeNode right = root.right;
            while (right.left != null) right = right.left;
            root.val = right.val;
            root.right = deleteNode(root.right, root.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
