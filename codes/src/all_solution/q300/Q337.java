package all_solution.q300;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (map.containsKey(root)) return map.get(root);
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int here = root.val;
        if (root.left != null) here += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) here += rob(root.right.left) + rob(root.right.right);
        int next = rob(root.left) + rob(root.right);
        int res = Math.max(next, here);
        map.put(root, res);
        return res;
    }
}
