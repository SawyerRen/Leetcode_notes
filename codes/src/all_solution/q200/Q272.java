package all_solution.q200;

import model.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) return;
        helper(res, root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(res.peekFirst() - target) > Math.abs(root.val - target)) {
                res.removeFirst();
                res.addLast(root.val);
            }
        } else {
            res.addLast(root.val);
        }
        helper(res, root.right, target, k);
    }
}
