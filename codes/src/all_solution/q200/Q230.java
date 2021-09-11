package all_solution.q200;

import model.TreeNode;

public class Q230 {
    int count = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        findKth(root, k);
        return res;
    }

    private void findKth(TreeNode root, int k) {
        if (root == null) return;
        findKth(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        findKth(root.right, k);
    }
}
