package company.fbfinal;

import model.TreeNode;

import java.util.Stack;

public class Q938 {
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        int res = root.val;
        res += rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        return res;
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.val >= low && pop.val <= high) {
                res += pop.val;
            }
            if (pop.val > low) {
                if (pop.left != null) stack.push(pop.left);
            }
            if (pop.val < high) {
                if (pop.right != null) stack.push(pop.right);
            }
        }
        return res;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int res = 0;
        if (root.val >= low && root.val <= high) res += root.val;
        res += rangeSumBST(root.left, low, high);
        res += rangeSumBST(root.right, low, high);
        return res;
    }
}
