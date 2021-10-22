package company.facebook;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1382 {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(list.get(left));
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, left, mid - 1);
        root.right = helper(list, mid + 1, right);
        return root;
    }
}
