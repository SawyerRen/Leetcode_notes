package all_solution.q300;

import model.TreeNode;

import java.util.*;

public class Q314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int min = 0, max = 0;
        if (root == null) return res;
        queue.add(root);
        cols.add(0);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer col = cols.poll();
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(poll.val);
            min = Math.min(col, min);
            max = Math.max(col, max);
            if (poll.left != null) {
                queue.add(poll.left);
                cols.add(col - 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                cols.add(col + 1);
            }
        }
        for (int i = min; i < max + 1; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
