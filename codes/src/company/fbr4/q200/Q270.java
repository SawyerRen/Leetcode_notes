package company.fbr4.q200;

import model.TreeNode;

import java.util.Map;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(res - target) > Math.abs(root.val - target)) {
                res = root.val;
            }
            if (root.val < target) root = root.right;
            else root = root.left;
        }
        return res;
    }
}
