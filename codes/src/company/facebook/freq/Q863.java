package company.facebook.freq;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(root, map, target);
        List<Integer> res = new ArrayList<>();
        getVal(map, res, root, 0, k);
        return res;
    }

    private void getVal(Map<TreeNode, Integer> map, List<Integer> res, TreeNode root, int distance, int k) {
        if (root == null) return;
        if (map.containsKey(root)) distance = map.get(root);
        if (distance == k) {
            res.add(root.val);
        }
        getVal(map, res, root.left, distance + 1, k);
        getVal(map, res, root.right, distance + 1, k);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = helper(root.left, map, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = helper(root.right, map, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}
