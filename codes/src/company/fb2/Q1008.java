package company.fb2;

import model.TreeNode;

public class Q1008 {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, max);
        return root;
    }
}
