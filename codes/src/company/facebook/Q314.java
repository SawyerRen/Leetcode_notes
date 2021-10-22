package company.facebook;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        queue.add(root);
        cols.add(0);
        int minCol = 0, maxCol = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer col = cols.poll();
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                cols.add(col - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                cols.add(col + 1);
            }
        }
        for (int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
