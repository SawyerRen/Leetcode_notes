package company.facebook;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(root.val);
        helper(res, root.right, depth + 1);
        helper(res, root.left, depth + 1);
    }
}
