package frequency.q200;

import model.TreeNode;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        double minDiff = Integer.MAX_VALUE;
        int res = 0;
        while (root != null) {
            if (root.val == target) return root.val;
            if (root.val < target) {
                if (minDiff > target - root.val) {
                    res = root.val;
                    minDiff = target - root.val;
                }
                root = root.right;
            } else {
                if (minDiff > root.val - target) {
                    res = root.val;
                    minDiff = root.val - target;
                }
                root = root.left;
            }
        }
        return res;
    }
}
