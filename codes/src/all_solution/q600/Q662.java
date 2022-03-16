package all_solution.q600;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q662 {
    int res = 0;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 0, 1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> list, int level, int index) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(index);
        }
        res = Math.max(res, index - list.get(level) + 1);
        helper(root.left, list, level + 1, index * 2);
        helper(root.right, list, level + 1, index * 2 + 1);
    }
}
