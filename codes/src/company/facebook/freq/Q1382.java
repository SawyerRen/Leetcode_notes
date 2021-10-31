package company.facebook.freq;

import com.sun.source.tree.Tree;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        buildList(list, root);
        return buildTree(list, 0, list.size() - 1);
    }

    private TreeNode buildTree(List<Integer> list, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(list.get(left));
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, left, mid - 1);
        root.right = buildTree(list, mid + 1, right);
        return root;
    }

    private void buildList(List<Integer> list, TreeNode root) {
        if (root == null) return;
        buildList(list, root.left);
        list.add(root.val);
        buildList(list, root.right);
    }
}
