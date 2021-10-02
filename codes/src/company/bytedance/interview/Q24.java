package company.bytedance.interview;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Q24 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        helper(builder, root);
        return builder.toString();
    }

    private void helper(StringBuilder builder, TreeNode root) {
        if (root == null) builder.append("null").append(",");
        else {
            builder.append(root.val).append(",");
            helper(builder, root.left);
            helper(builder, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return des(list);
    }

    private TreeNode des(LinkedList<String> list) {
        if (list.size() == 0) return null;
        String s = list.pollFirst();
        if (s.equals("null")) return null;
        int val = Integer.parseInt(s);
        TreeNode root = new TreeNode(val);
        root.left = des(list);
        root.right = des(list);
        return root;
    }
}
