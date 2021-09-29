package topics.tree;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q449 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            helper(root, builder);
            return builder.toString();
        }

        private void helper(TreeNode root, StringBuilder builder) {
            if (root == null) return;
            builder.append(root.val).append(",");
            helper(root.left, builder);
            helper(root.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) return null;
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return des(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private TreeNode des(Queue<String> queue, int minValue, int maxValue) {
            if (queue.isEmpty()) return null;
            int peek = Integer.parseInt(queue.peek());
            if (peek < minValue || peek > maxValue) return null;
            int val = Integer.parseInt(queue.poll());
            TreeNode root = new TreeNode(val);
            root.left = des(queue, minValue, val);
            root.right = des(queue, val, maxValue);
            return root;
        }
    }
}

