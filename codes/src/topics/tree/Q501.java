package topics.tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q501 {
    int maxCount = 0;
    Integer preVal;
    int count = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        if (preVal == null) {
            preVal = root.val;
        }
        if (root.val == preVal) {
            count++;
        } else {
            preVal = root.val;
            count = 1;
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        helper(root.right, list);
    }
}
