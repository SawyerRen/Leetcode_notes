package all_solution.q500;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        leftBound(res, root.left);
        leaves(res, root.left);
        leaves(res, root.right);
        LinkedList<Integer> right = new LinkedList<>();
        rightBound(right, root.right);
        res.addAll(right);
        res.addFirst(root.val);
        return res;
    }

    private void rightBound(LinkedList<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        list.addFirst(root.val);
        if (root.right != null) {
            rightBound(list, root.right);
        } else {
            rightBound(list, root.left);
        }
    }

    private void leaves(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        leaves(res, root.left);
        leaves(res, root.right);
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
