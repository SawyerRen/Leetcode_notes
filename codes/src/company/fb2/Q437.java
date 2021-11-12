package company.fb2;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(map, root, 0, targetSum);
        return res;
    }

    private void helper(Map<Integer, Integer> map, TreeNode root, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        if (map.containsKey(sum - target)) {
            res += map.get(sum - target);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(map, root.left, sum, target);
        helper(map, root.right, sum, target);
        map.put(sum, map.get(sum) - 1);
    }
}
