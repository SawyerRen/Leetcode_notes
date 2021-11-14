package company.fbfinal;

import model.TreeNode;

import java.util.*;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        buildGraph(map, root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                break;
            }
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            k--;
        }
        return res;
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
}
