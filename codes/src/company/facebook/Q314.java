package company.facebook;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            int col = cols.poll();
            min = Math.min(min, col);
            max = Math.max(max, col);
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
                cols.add(col - 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                cols.add(col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
