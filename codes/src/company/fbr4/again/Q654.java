package company.fbr4.again;

import model.TreeNode;

public class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int max = nums[left], maxIndex = left;
        for (int i = left; i < right + 1; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, left, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, right);
        return root;
    }
}
