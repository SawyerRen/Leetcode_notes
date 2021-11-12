package company.fbr5.q800;

import model.TreeNode;

import java.util.*;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        find(map, root, target);
        List<Integer> res = new ArrayList<>();
        helper(map, res, root, k, 0);
        return res;
    }

    private void helper(Map<TreeNode, Integer> map, List<Integer> res, TreeNode root, int k, int distance) {
        if (root == null) return;
        if (map.containsKey(root)) distance = map.get(root);
        if (distance == k) res.add(root.val);
        helper(map, res, root.left, k, distance + 1);
        helper(map, res, root.right, k, distance + 1);
    }

    private int find(Map<TreeNode, Integer> map, TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(map, root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(map, root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}
