package company.fb2;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, 0, targetSum);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, TreeNode root, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(list));
            }
        } else {
            helper(res, list, root.left, sum, target);
            helper(res, list, root.right, sum, target);
        }
        list.remove(list.size() - 1);
    }
}
