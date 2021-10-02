package company.bytedance.interview;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        helper(root.right, depth + 1, res);
        helper(root.left, depth + 1, res);
    }
}
