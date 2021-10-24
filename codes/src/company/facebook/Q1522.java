package company.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q1522 {
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    int res = 0;

    public int diameter(Node root) {
        helper(root);
        return res;
    }

    private int helper(Node root) {
        if (root == null) return 0;
        int max = 0, secondMax = 0;
        for (Node child : root.children) {
            int d = helper(child);
            if (d > max) {
                secondMax = max;
                max = d;
            } else if (d > secondMax) {
                secondMax = d;
            }
        }
        res = Math.max(res, max + secondMax);
        return max + 1;
    }
}
