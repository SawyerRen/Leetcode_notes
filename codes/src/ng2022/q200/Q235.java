package ng2022.q200;

import model.TreeNode;

public class Q235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else if (root.val > q.val && root.val > p.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val < q.val && root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        if (root.val > q.val && root.val > p.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
