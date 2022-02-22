package all_solution.q200;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, root, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, TreeNode root, StringBuilder builder) {
        if (root == null) return;
        int len = builder.length();
        if (builder.length() == 0) {
            builder.append(root.val);
        } else {
            builder.append("->").append(root.val);
        }
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
            builder.setLength(len);
            return;
        }
        helper(res, root.left, builder);
        helper(res, root.right, builder);
        builder.setLength(len);
    }
}
