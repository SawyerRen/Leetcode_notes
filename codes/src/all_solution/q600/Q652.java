package all_solution.q600;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(map, res, root);
        return res;
    }

    private String helper(Map<String, Integer> map, List<TreeNode> res, TreeNode root) {
        if (root == null) return "null";
        String left = helper(map, res, root.left);
        String right = helper(map, res, root.right);
        String cur = root.val + "," + left + "," + right;
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        if (map.get(cur) == 2) res.add(root);
        return cur;
    }
}
