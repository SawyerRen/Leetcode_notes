package company.fbr4.q600;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            if (sum < k) i++;
            else j--;
        }
        return false;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
