package company.fbr5.q200;

import model.TreeNode;

import java.util.Stack;

public class Q230 {
    int res = 0;
    int count = 0;


    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        helper(root.right, k);
    }

    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if (k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;
    }
}
