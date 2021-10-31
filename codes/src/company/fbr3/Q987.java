package company.fbr3;

import model.TreeNode;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        if (root == null) return res;
        Map<Integer, List<Node>> map = new HashMap<>();
        int min = 0, max = 0, row = 0;
        nodes.add(root);
        cols.add(0);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                Integer col = cols.poll();
                min = Math.min(min, col);
                max = Math.max(max, col);
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(new Node(row, col, node.val));
                if (node.left != null) {
                    nodes.add(node.left);
                    cols.add(col - 1);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                    cols.add(col + 1);
                }
            }
            row++;
        }
        for (int i = min; i < max + 1; i++) {
            List<Node> nodeList = map.get(i);
            nodeList.sort((a, b) -> {
                if (a.row == b.row) return a.val - b.val;
                return a.row - b.row;
            });
            List<Integer> list = new ArrayList<>();
            for (Node node : nodeList) {
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
