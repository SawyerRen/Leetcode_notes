package ng2022.oa.amazon.all;

import model.TreeNode;

public class DistanceBetweenNodesInBST {
    public int bstDistance(TreeNode root, int node1, int node2) {
        if (root == null) return -1;
        TreeNode lca = lca(root, node1, node2);
        return getDistance(lca, node1) + getDistance(lca, node2);
    }

    private int getDistance(TreeNode src, int dest) {
        if (src.val == dest) return 0;
        TreeNode node = src.left;
        if (src.val < dest) {
            node = src.right;
        }
        return 1 + getDistance(node, dest);
    }

    private TreeNode lca(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
