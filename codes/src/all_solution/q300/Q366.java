package all_solution.q300;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private int helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return -1;
        int left = helper(res, root.left, level);
        int right = helper(res, root.right, level);
        level = Math.max(left, right) + 1;
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
}
