package company.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1650 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node n1 = p, n2 = q;
        while (n1 != n2) {
            n1 = n1 == null ? q : n1.parent;
            n2 = n2 == null ? p : n2.parent;
        }
        return n1;
    }

    public Node lowestCommonAncestor1(Node p, Node q) {
        Set<Node> path = new HashSet<>();
        while (p != null) {
            path.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (path.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }
}
