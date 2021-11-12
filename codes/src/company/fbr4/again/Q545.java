package company.fbr4.again;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        List<Integer> left = new ArrayList<>();
        leftBound(left, root.left);
        LinkedList<Integer> right = new LinkedList<>();
        rightBound(right, root.right);
        List<Integer> leaves = new ArrayList<>();
        addLeaves(leaves, root.left);
        addLeaves(leaves, root.right);
        res.addAll(left);
        res.addAll(leaves);
        res.addAll(right);
        return res;
    }

    private void addLeaves(List<Integer> leaves, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) leaves.add(root.val);
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
        if (root.left != null) leftBound(left, root.left);
        else leftBound(left, root.right);
    }
}
