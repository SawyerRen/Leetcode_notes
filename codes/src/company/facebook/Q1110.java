package company.facebook;

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
        if (!set.contains(root.val)) res.add(root);
        helper(res, root, set);
        return res;
    }

    private TreeNode helper(List<TreeNode> res, TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        root.left = helper(res, root.left, set);
        root.right = helper(res, root.right, set);
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}
