package all_solution.q600;

import model.TreeNode;

public class Q669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val >= low && root.val <= high) return root;
        if (root.left == null && root.right == null) return null;
        if (root.left == null) {
            root = root.right;
            return root;
        }
        if (root.right == null) {
            root = root.left;
            return root;
        }
        return root;
    }
}
