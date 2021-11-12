package company.fb2;

public class Q510 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }
        while (node.parent != null) {
            if (node == node.parent.left) return node.parent;
            node = node.parent;
        }
        return null;
    }
}
