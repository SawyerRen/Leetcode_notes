package frequency.q300;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        int height = Math.max(helper(root.left, res), helper(root.right, res)) + 1;
        if (height > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height - 1).add(root.val);
        return height;
    }
}
