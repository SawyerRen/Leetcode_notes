package company.fbr5.q100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, targetSum, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int target, int sum) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        helper(res, list, root.left, target, sum);
        helper(res, list, root.right, target, sum);
        list.remove(list.size() - 1);
    }
}
