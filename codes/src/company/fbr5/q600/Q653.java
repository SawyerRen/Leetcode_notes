package company.fbr5.q600;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
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
