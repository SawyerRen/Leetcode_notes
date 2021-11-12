package company.fbr4.q1100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        helper(res, set, root);
        if (!set.contains(root.val)) res.add(root);
        return res;
    }

    private TreeNode helper(List<TreeNode> res, Set<Integer> set, TreeNode root) {
        if (root == null) return null;
        root.left = helper(res, set, root.left);
        root.right = helper(res, set, root.right);
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}
