package all_solution.q100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        if (left > right) {
            List<TreeNode> res = new ArrayList<>();
            res.add(null);
            return res;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftLists = generateTrees(left, i - 1);
            List<TreeNode> rightLists = generateTrees(i + 1, right);
            for (TreeNode leftNode : leftLists) {
                for (TreeNode rightNode : rightLists) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
