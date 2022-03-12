package all_solution.q400;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Q449 {
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        se(root, builder);
        return builder.toString();
    }

    private void se(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val).append(",");
        se(root.left, builder);
        se(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return des(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode des(LinkedList<String> queue, int min, int max) {
        if (queue.isEmpty()) return null;
        String s = queue.peekFirst();
        int val = Integer.parseInt(s);
        if (val <= min || val >= max) return null;
        queue.pollFirst();
        TreeNode root = new TreeNode(val);
        root.left = des(queue, min, root.val);
        root.right = des(queue, root.val, max);
        return root;
    }
}