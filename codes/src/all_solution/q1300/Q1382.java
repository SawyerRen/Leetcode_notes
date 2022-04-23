package all_solution.q1300;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(list, root);
        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, left, mid - 1);
        root.right = build(list, mid + 1, right);
        return root;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
