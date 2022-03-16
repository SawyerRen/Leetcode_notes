package all_solution.q600;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) return true;
            if (sum < k) left++;
            else right--;
        }
        return false;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
