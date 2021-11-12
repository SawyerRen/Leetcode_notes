package company.fb2;

import model.TreeNode;

public class Q536 {
    int index = 0;

    public TreeNode str2tree(String s) {
        if (index >= s.length()) return null;
        StringBuilder builder = new StringBuilder();
        while (index < s.length() && s.charAt(index) != '(' && s.charAt(index) != ')') {
            builder.append(s.charAt(index++));
        }
        TreeNode root = new TreeNode(Integer.parseInt(builder.toString()));
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            root.left = str2tree(s);
            index++;
        }
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            root.right = str2tree(s);
            index++;
        }
        return root;
    }
}
