package company.fbfinal;

import com.sun.source.tree.Tree;
import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        helper(res, root.right, depth + 1);
        helper(res, root.left, depth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res.add(queue.peek().val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }
        return res;
    }
}
