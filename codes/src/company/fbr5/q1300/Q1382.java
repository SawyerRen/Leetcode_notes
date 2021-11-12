package company.fbr5.q1300;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return getRoot(list, 0, list.size() - 1);
    }

    private TreeNode getRoot(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = getRoot(list, left, mid - 1);
        root.right = getRoot(list, mid + 1, right);
        return root;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
