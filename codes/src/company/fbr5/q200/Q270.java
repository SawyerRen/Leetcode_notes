package company.fbr5.q200;

import model.TreeNode;

import java.util.Map;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double minDiff = Math.abs(target - res);
        while (root != null) {
            if (minDiff > Math.abs(target - root.val)) {
                res = root.val;
                minDiff = Math.min(minDiff, Math.abs(target - root.val));
            }
            if (root.val < target) root = root.right;
            else root = root.left;
        }
        return res;
    }
}
