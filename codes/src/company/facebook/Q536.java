package company.facebook;

import model.TreeNode;

public class Q536 {
    int index = 0;

    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        return helper(s.toCharArray());
    }

    private TreeNode helper(char[] chars) {
        if (index == chars.length) return null;
        StringBuilder builder = new StringBuilder();
        while (index < chars.length && chars[index] != '(' && chars[index] != ')') {
            builder.append(chars[index++]);
        }
        TreeNode root = new TreeNode(Integer.parseInt(builder.toString()));
        if (index < chars.length && chars[index] == '(') {
            index++;
            root.left = helper(chars);
            index++;
            if (index < chars.length && chars[index] == '(') {
                index++;
                root.right = helper(chars);
                index++;
            }
        }
        return root;
    }
}
