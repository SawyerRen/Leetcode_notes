package all_solution.q100;


public class Q116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) return null;
        Node left = root;
        while (left.left != null) {
            Node node = left;
            while (node != null) {
                node.left.next = node.right;
                if (node.next == null) {
                    node.right.next = null;
                } else {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            left = left.left;
        }
        return root;
    }
}
