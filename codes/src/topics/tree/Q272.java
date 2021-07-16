package topics.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) return;
        helper(res, root.left, target, k);
        int val = root.val;
        if (res.size() == k) {
            if (Math.abs(val - target) < Math.abs(res.peekFirst() - target)) {
                res.pollFirst();
                res.add(val);
            }
        } else {
            res.add(val);
        }
        helper(res, root.right, target, k);
    }
}
