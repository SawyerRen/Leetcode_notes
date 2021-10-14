package company.facebook;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        find(map, root, target);
        List<Integer> res = new ArrayList<>();
        helper(res, root, map, map.get(root), k);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, Map<TreeNode, Integer> map, int length, int k) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == k) res.add(root.val);
        helper(res, root.left, map, length + 1, k);
        helper(res, root.right, map, length + 1, k);
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
