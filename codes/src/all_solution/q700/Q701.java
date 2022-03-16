package all_solution.q700;

import model.TreeNode;

public class Q701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val && root.left == null) {
            root.left = new TreeNode(val);
            return root;
        }
        if (root.val < val && root.right == null) {
            root.right = new TreeNode(val);
            return root;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
