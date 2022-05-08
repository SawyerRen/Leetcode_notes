package all_solution.q1600;


public class Q1650 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p, q1 = q;
        while (p1 != q1) {
            p1 = p1 != null ? p1.parent : q;
            q1 = q1 != null ? q1.parent : p;
        }
        return p1;
    }
}
