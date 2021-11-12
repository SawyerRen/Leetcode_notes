package company.fbr5.q300;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        nodes.add(root);
        cols.add(0);
        int min = 0, max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer col = cols.poll();
            min = Math.min(col, min);
            max = Math.max(col, max);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                cols.add(col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
