package company.fbr4.q600;

import model.TreeNode;

public class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int maxIndex = left, max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, left, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, right);
        return root;
    }
}
