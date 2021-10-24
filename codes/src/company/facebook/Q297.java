package company.facebook;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Q297 {
}

//public class Codec {
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        StringBuilder builder = new StringBuilder();
//        helper(builder, root);
//        return builder.toString();
//    }
//
//    private void helper(StringBuilder builder, TreeNode root) {
//        if (root == null) {
//            builder.append("null,");
//            return;
//        }
//        builder.append(root.val).append(",");
//        helper(builder, root.left);
//        helper(builder, root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if (data.startsWith("null")) return null;
//        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
//        return helper2(list);
//    }
//
//    private TreeNode helper2(LinkedList<String> list) {
//        if (list.size() == 0) return null;
//        String s = list.pollFirst();
//        if (s.equals("null")) return null;
//        TreeNode root = new TreeNode(Integer.parseInt(s));
//        root.left = helper2(list);
//        root.right = helper2(list);
//        return root;
//    }
//}