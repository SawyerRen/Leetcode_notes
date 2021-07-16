package topics.tree;

import java.util.Stack;

public class Q255 {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length < 2) return true;
        Stack<Integer> stack = new Stack<>();
        stack.push(preorder[0]);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < preorder.length; i++) {
            if (preorder[i] < min) return false;
            // 还在往左子节点遍历，是递减的情况
            if (preorder[i] < preorder[i - 1]) {
                stack.push(preorder[i]);
                // 出现右子节点
            } else {
                // 找到比当前节点小的最大节点，就是这个右子节点的父节点
                while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                    min = stack.pop();
                }
                stack.push(preorder[i]);
            }
        }
        return true;
    }
}
