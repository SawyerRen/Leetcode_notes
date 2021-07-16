package topics.tree;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
}

class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("null,");
            return;
        }
        builder.append(root.val).append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = deserialize(queue);
        return root;
    }

    private TreeNode deserialize(Queue<String> queue) {
        String poll = queue.poll();
        if ("null".equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}