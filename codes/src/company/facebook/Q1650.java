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
        Node curP = p, curQ = q;
        while (curP != curQ) {
            curP = curP == null ? q : curP.parent;
            curQ = curQ == null ? p : curQ.parent;
        }
        return curP;
    }
}
