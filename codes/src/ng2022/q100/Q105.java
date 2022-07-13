package ng2022.q100;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105 {
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorderMap, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end) {
        if (start > end) return null;
        int rootVal = preorder[index++];
        int inorderIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, inorderMap, start, inorderIndex - 1);
        root.right = helper(preorder, inorderMap, inorderIndex + 1, end);
        return root;
    }
}
