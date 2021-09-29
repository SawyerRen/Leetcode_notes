package all_solution.q200;

import model.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {

}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        helper(builder, root);
        return builder.toString();
    }

    private void helper(StringBuilder builder, TreeNode root) {
        if (root == null) {
            builder.append("null").append(",");
            return;
        }
        builder.append(root.val).append(",");
        helper(builder, root.left);
        helper(builder, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return des(queue);
    }

    private TreeNode des(Queue<String> queue) {
        if (queue.size() == 0) return null;
        String peek = queue.poll();
        if (peek.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(peek));
        root.left = des(queue);
        root.right = des(queue);
        return root;
    }
}