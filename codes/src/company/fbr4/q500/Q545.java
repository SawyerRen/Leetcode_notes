package company.fbr4.q500;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        List<Integer> left = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        LinkedList<Integer> right = new LinkedList<>();
        leftBound(left, root.left);
        addLeaves(leaves, root.left);
        addLeaves(leaves, root.right);
        rightBound(right, root.right);
        res.addAll(left);
        res.addAll(leaves);
        res.addAll(right);
        return res;
    }

    private void addLeaves(List<Integer> leaves, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        addLeaves(leaves, root.left);
        addLeaves(leaves, root.right);
    }

    private void rightBound(LinkedList<Integer> right, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        right.addFirst(root.val);
        if (root.right != null) rightBound(right, root.right);
        else rightBound(right, root.left);
    }

    private void leftBound(List<Integer> left, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        left.add(root.val);
        if (root.left != null) {
            leftBound(left, root.left);
        } else {
            leftBound(left, root.right);
        }
    }
}
