package all_solution.q200;

import model.TreeNode;

public class Q222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = 0, rightHeight = 0;
        TreeNode cur = root;
        while (cur != null) {
            leftHeight++;
            cur = cur.left;
        }
        cur = root;
        while (cur != null) {
            rightHeight++;
            cur = cur.right;
        }
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
