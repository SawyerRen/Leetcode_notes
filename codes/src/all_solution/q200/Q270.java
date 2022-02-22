package all_solution.q200;

import model.TreeNode;

public class Q270 {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(res - target)) {
                res = cur.val;
            }
            if (cur.val == target) {
                return cur.val;
            } else if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }
}
