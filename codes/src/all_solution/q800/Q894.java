package all_solution.q800;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q894 {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n % 2 == 0) return list;
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1) {
            list.add(new TreeNode());
            return list;
        }
        n--;
        for (int i = 1; i < n; i++) {
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(n - i);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode();
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        memo.put(n, list);
        return list;
    }
}
