package company.fbfinal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q1382 {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        buildList(list, root);
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);
        return root;
    }

    private void buildList(List<Integer> list, TreeNode root) {
        if (root == null) return;
        buildList(list, root.left);
        list.add(root.val);
        buildList(list, root.right);
    }
}
