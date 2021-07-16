package topics.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, TreeNode root, StringBuilder builder) {
        if (root == null) return;
        int len = builder.length();
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            res.add(builder.toString());
            builder.setLength(len);
            return;
        }
        builder.append(root.val).append("->");
        helper(res, root.left, builder);
        helper(res, root.right, builder);
        builder.setLength(len);
    }
}
