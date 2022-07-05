package frequency.q200;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            helper1(root, builder);
            return builder.toString();
        }

        private void helper1(TreeNode root, StringBuilder builder) {
            if (root == null) {
                builder.append("null").append(",");
                return;
            }
            builder.append(root.val).append(",");
            helper1(root.left, builder);
            helper1(root.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return helper2(queue);
        }

        private TreeNode helper2(Queue<String> queue) {
            if (queue.size() == 0) return null;
            String poll = queue.poll();
            if (poll.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(poll));
            root.left = helper2(queue);
            root.right = helper2(queue);
            return root;
        }
    }
}
