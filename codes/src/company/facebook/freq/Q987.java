package company.facebook.freq;

import model.TreeNode;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        queue.add(root);
        cols.add(0);
        int min = 0, max = 0;
        int row = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                int col = cols.poll();
                min = Math.min(min, col);
                max = Math.max(max, col);
                Node node = new Node(row, col, poll.val);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node);
                if (poll.left != null) {
                    queue.add(poll.left);
                    cols.add(col - 1);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    cols.add(col + 1);
                }
            }
            row++;
        }
        for (int i = min; i < max + 1; i++) {
            List<Node> nodes = map.get(i);
            nodes.sort((a, b) -> {
                if (a.row == b.row) return a.val - b.val;
                return a.row - b.row;
            });
            List<Integer> list = new ArrayList<>();
            for (Node node : nodes) {
                list.add(node.val);
            }
            res.add(list);
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
