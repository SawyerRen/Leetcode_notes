package company.fb2;

import model.TreeNode;

public class Q938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        int res = root.val;
        res += rangeSumBST(root.left, low, high);
        res += rangeSumBST(root.right, low, high);
        return res;
    }
}
