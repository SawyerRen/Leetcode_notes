package company.facebook;

/*
tree node 首先有指针可以指向parent，然后每一个node的值都是0或者1。
然后他给你一个指定的node，这个node的值现在要flip（0 ->1或者1->0），
然后parent的node的值是他两个children值的与 （&）。要做的是flip给定的node后更新整个tree。
 */
public class E1 {
    class Node {
        Node left;
        Node right;
        Node parent;
        int val;
    }

    void solution(Node root, Node node) {
        Node pre;
        node.val = 1 - node.val;
        while (node.parent != null) {
            pre = node;
            node = node.parent;
            if (pre.val == 0) {
                node.val = 0;
            } else {
                if (pre == node.left && node.right != null && node.right.val == 0) {
                    node.val = 0;
                } else if (pre == node.right && node.left != null && node.left.val == 0) {
                    node.val = 0;
                } else {
                    node.val = 1;
                }
            }
        }
    }
}
