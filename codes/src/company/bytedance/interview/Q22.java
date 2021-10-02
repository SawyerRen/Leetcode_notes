package company.bytedance.interview;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q22 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        dfs(root, map.get(root), K, res);
        return res;
    }

    private void dfs(TreeNode root, Integer dist, int k, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) dist = map.get(root);
        if (k == dist) res.add(root.val);
        dfs(root.left, dist + 1, k, res);
        dfs(root.right, dist + 1, k, res);
    }

    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}
