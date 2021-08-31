package topics.tree;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(map, root, targetSum, 0);
    }

    private int helper(Map<Integer, Integer> map, TreeNode root, int targetSum, int sum) {
        if (root == null) return 0;
        int res = 0;
        sum += root.val;
        if (map.containsKey(sum - targetSum)) res += map.get(sum - targetSum);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += helper(map, root.left, targetSum, sum);
        res += helper(map, root.right, targetSum, sum);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
