package ng2022.q400;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        helper(map, root, targetSum, 0);
        return res;
    }

    private void helper(Map<Long, Integer> map, TreeNode root, int targetSum, long preSum) {
        if (root == null) return;
        preSum += root.val;
        if (map.containsKey(preSum - targetSum)) {
            res += map.get(preSum - targetSum);
        }
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        helper(map, root.left, targetSum, preSum);
        helper(map, root.right, targetSum, preSum);
        map.put(preSum, map.get(preSum) - 1);
    }
}
