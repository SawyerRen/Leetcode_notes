package company.fbfinal;

import model.TreeNode;

import java.util.*;

public class Q987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        nodes.add(root);
        cols.add(0);
        int minCol = 0, maxCol = 0, row = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                Integer col = cols.poll();
                minCol = Math.min(col, minCol);
                maxCol = Math.max(col, maxCol);
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
        for (int i = minCol; i <= maxCol; i++) {
            List<Node> list = map.get(i);
            list.sort((a, b) -> a.row == b.row ? a.value - b.value : a.row - b.row);
            List<Integer> list1 = new ArrayList<>();
            for (Node node : list) {
                list1.add(node.value);
            }
            res.add(list1);
        }
        return res;
    }

    class Node {
        int row;
        int col;
        int value;

        public Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
