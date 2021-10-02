package all_solution.q800;

import model.TreeNode;

import java.util.*;

public class Q863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        build(root, null, graph);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == k) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                List<TreeNode> nodeList = graph.get(poll);
                for (TreeNode node : nodeList) {
                    if (visited.contains(node)) continue;
                    queue.add(node);
                    visited.add(node);
                }
            }
            dist++;
        }
        return res;
    }

    private void build(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
            if (parent != null) {
                graph.get(node).add(parent);
                graph.get(parent).add(node);
            }
        }
        build(node.left, node, graph);
        build(node.right, node, graph);
    }
}
