package company.facebook.freq;

import model.TreeNode;

import java.util.Stack;

public class Q938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val >= low && node.val <= high) {
                res += node.val;
            }
            if (node.val > low && node.left != null) {
                stack.add(node.left);
            }
            if (node.val < high && node.right != null) {
                stack.add(node.right);
            }
        }
        return res;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST1(root.right, low, high);
        if (root.val > high) return rangeSumBST1(root.left, low, high);
        int res = root.val;
        res += rangeSumBST1(root.left, low, high);
        res += rangeSumBST1(root.right, low, high);
        return res;
    }
}
