package company.bytedance.interview;

import model.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class Q23 {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        build(root, builder);
        return builder.toString();
    }

    private void build(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val).append(",");
        build(root.left, builder);
        build(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return des(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode des(LinkedList<String> list, int min, int max) {
        if (list.size() == 0) return null;
        String s = list.peekFirst();
        int val = Integer.parseInt(s);
        if (val < min || val > max) return null;
        list.pollFirst();
        TreeNode root = new TreeNode(val);
        root.left = des(list, min, val);
        root.right = des(list, val, max);
        return root;
    }
}