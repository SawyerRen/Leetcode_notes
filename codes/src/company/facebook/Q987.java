package company.facebook;

import model.TreeNode;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int max = 0, min = 0;
        Map<Integer, List<Node>> map = new HashMap<>();
        queue.add(root);
        cols.add(0);
        int row = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer col = cols.poll();
                max = Math.max(col, max);
                min = Math.min(col, min);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new Node(row, col, poll.val));
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
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            List<Node> nodes = map.get(i);
            nodes.sort((a, b) -> {
                if (a.row == b.row) return a.val - b.val;
                return a.row - b.row;
            });
            ArrayList<Integer> list = new ArrayList<>();
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
