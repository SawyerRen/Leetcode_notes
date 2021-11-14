package company.fbfinal;

import model.TreeNode;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(res - target) > Math.abs(root.val - target)) {
                res = root.val;
            }
            if (root.val > target) root = root.left;
            else root = root.right;
        }
        return res;
    }
}
