package company.facebook;

import model.TreeNode;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        queue.add(root);
        cols.add(0);
        int level = 0;
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int col = cols.poll();
                min = Math.min(min, col);
                max = Math.max(max, col);
                List<Node> list = map.getOrDefault(col, new ArrayList<>());
                list.add(new Node(level, col, poll.val));
                map.put(col, list);
                if (poll.left != null) {
                    queue.add(poll.left);
                    cols.add(col - 1);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    cols.add(col + 1);
                }
            }
            level++;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Node> nodes = map.get(i);
            nodes.sort((a, b) -> (a.row == b.row ? a.val - b.val : a.row - b.row));
            List<Integer> vals = new ArrayList<>();
            for (Node node : nodes) {
                vals.add(node.val);
            }
            res.add(vals);
        }
        return res;
    }

    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
