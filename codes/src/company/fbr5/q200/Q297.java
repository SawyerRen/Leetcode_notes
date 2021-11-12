package company.fbr5.q200;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Q297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            se(builder, root);
            return builder.toString();
        }

        private void se(StringBuilder builder, TreeNode root) {
            if (root == null) {
                builder.append("null,");
                return;
            }
            builder.append(root.val).append(",");
            se(builder, root.left);
            se(builder, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
            return helper(list);
        }

        private TreeNode helper(LinkedList<String> list) {
            if (list.size() == 0) return null;
            String s = list.pollFirst();
            if (s.equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(s));
            root.left = helper(list);
            root.right = helper(list);
            return root;
        }
    }
}
