package company.facebook.freq;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int minCol = 0, maxCol = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer col = cols.poll();
            minCol = Math.min(col, minCol);
            maxCol = Math.max(col, maxCol);
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
        for (int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
