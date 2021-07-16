package topics.tree;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        nodeQueue.add(root);
        indexQueue.add(0);
        int min = 0, max = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer index = indexQueue.poll();
            min = Math.min(min, index);
            max = Math.max(max, index);
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<>());
            }
            map.get(index).add(node.val);
            if (node.left != null) {
                nodeQueue.add(node.left);
                indexQueue.add(index - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                indexQueue.add(index + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            List<Integer> list = map.get(i);
            res.add(list);
        }
        return res;
    }
}
