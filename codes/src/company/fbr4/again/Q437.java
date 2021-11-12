package company.fbr4.again;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(map, root, targetSum, 0);
        return res;
    }

    private void helper(Map<Integer, Integer> map, TreeNode root, int target, int sum) {
        if (root == null) return;
        sum += root.val;
        if (map.containsKey(sum - target)) res += map.get(sum - target);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(map, root.left, target, sum);
        helper(map, root.right, target, sum);
        map.put(sum, map.get(sum) - 1);
    }
}
