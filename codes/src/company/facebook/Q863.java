package company.facebook;

import model.TreeNode;

import java.util.*;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        buildGraph(map, root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                for (TreeNode node : map.get(poll)) {
                    if (!visited.contains(node)) {
                        queue.add(node);
                        visited.add(node);
                    }
                }
            }
            k--;
        }
        return new ArrayList<>();
    }

    private void buildGraph(Map<TreeNode, Set<TreeNode>> map, TreeNode node, TreeNode parent) {
        if (node == null) return;
        map.putIfAbsent(node, new HashSet<>());
        if (parent != null) {
            map.get(parent).add(node);
            map.get(node).add(parent);
        }
        buildGraph(map, node.left, node);
        buildGraph(map, node.right, node);
    }

    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, Integer> map = new HashMap<>();
        buildMap(map, root, target);
        List<Integer> res = new ArrayList<>();
        helper(res, map, root, k, 0);
        return res;
    }

    private void helper(List<Integer> res, Map<TreeNode, Integer> map, TreeNode root, int k, int distance) {
        if (root == null) return;
        if (map.containsKey(root)) {
            distance = map.get(root);
        }
        if (distance == k) res.add(root.val);
        helper(res, map, root.left, k, distance + 1);
        helper(res, map, root.right, k, distance + 1);
    }

    private int buildMap(Map<TreeNode, Integer> map, TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = buildMap(map, root.left, target);
        int right = buildMap(map, root.right, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
}
