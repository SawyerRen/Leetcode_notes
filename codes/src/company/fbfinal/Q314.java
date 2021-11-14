package company.fbfinal;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        nodes.add(root);
        cols.add(0);
        int minCol = 0, maxCol = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer col = cols.poll();
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
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
        for (int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
