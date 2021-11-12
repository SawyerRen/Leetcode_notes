package company.fb2;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        leftBound(res, root.left);
        addLeaves(res, root.left);
        addLeaves(res, root.right);
        rightBound(res, root.right);
        return res;
    }

    private void addLeaves(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        addLeaves(res, root.left);
        addLeaves(res, root.right);
    }

    private void rightBound(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right == null) {
            rightBound(res, root.left);
        } else {
            rightBound(res, root.right);
        }
        res.add(root.val);
    }

    private void leftBound(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        res.add(root.val);
        if (root.left != null) {
            leftBound(res, root.left);
        } else {
            leftBound(res, root.right);
        }
    }
}
