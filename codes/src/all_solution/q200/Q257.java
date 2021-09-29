package all_solution.q200;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), root);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, TreeNode root) {
        if (root == null) return;
        int len = builder.length();
        if (root.left == null && root.right == null) {
            builder.append(root.val);
            res.add(builder.toString());
            builder.setLength(len);
            return;
        }
        builder.append(root.val).append("->");
        helper(res, builder, root.left);
        helper(res, builder, root.right);
        builder.setLength(len);
    }
}
