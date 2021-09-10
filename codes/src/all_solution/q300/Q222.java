package all_solution.q300;

import model.TreeNode;

public class Q222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 1, rightHeight = 1;
        TreeNode cur = root;
        while (cur.left != null) {
            leftHeight++;
            cur = cur.left;
        }
        cur = root;
        while (cur.right != null) {
            rightHeight++;
            cur = cur.right;
        }
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
