package topics.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<>(), root, targetSum);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, TreeNode root, int targetSum) {
        if (root == null) return;
        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(root.val);
            res.add(new LinkedList<>(list));
            list.removeLast();
            return;
        }
        list.add(root.val);
        helper(res, list, root.left, targetSum - root.val);
        helper(res, list, root.right, targetSum - root.val);
        list.removeLast();
    }
}
