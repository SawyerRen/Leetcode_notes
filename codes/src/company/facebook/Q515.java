package company.facebook;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }
}
