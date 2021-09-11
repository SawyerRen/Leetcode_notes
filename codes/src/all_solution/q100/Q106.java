package all_solution.q100;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q106 {
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) return null;
        int rootVal = postorder[postIndex--];
        int inIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, inIndex + 1, right);
        root.left = helper(postorder, left, inIndex - 1);
        return root;
    }
}
