package company.fb2;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        for (int i : to_delete) {
            deleteSet.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        if (root == null) return res;
        if (!deleteSet.contains(root.val)) res.add(root);
        helper(res, root, deleteSet);
        return res;
    }

    private TreeNode helper(List<TreeNode> res, TreeNode root, Set<Integer> deleteSet) {
        if (root == null) return null;
        root.left = helper(res, root.left, deleteSet);
        root.right = helper(res, root.right, deleteSet);
        if (deleteSet.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}
