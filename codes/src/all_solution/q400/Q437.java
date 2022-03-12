package all_solution.q400;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        helper(root, targetSum, 0);
        return count;
    }

    private void helper(TreeNode root, int targetSum, int preSum) {
        if (root == null) return;
        preSum += root.val;
        if (map.containsKey(preSum - targetSum)) count += map.get(preSum - targetSum);
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        helper(root.left, targetSum, preSum);
        helper(root.right, targetSum, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}
