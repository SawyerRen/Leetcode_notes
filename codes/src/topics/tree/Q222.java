package topics.tree;

import model.TreeNode;

public class Q222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root, right = root;
        int leftHeight = 0, rightHeight = 0;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
