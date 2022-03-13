package all_solution.q500;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q508 {
    int max = 0, maxLen = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(map, root);
        int[] res = new int[maxLen];
        int index = 0;
        for (Integer sum : map.keySet()) {
            if (map.get(sum) == max) res[index++] = sum;
        }
        return res;
    }

    private int helper(Map<Integer, Integer> map, TreeNode root) {
        if (root == null) return 0;
        int left = helper(map, root.left);
        int right = helper(map, root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > max) {
            max = map.get(sum);
            maxLen = 1;
        } else if (map.get(sum) == max) {
            maxLen++;
        }
        return sum;
    }
}
