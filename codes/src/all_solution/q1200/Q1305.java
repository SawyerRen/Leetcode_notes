package all_solution.q1200;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur1 = root1, cur2 = root2;
        List<Integer> res = new ArrayList<>();
        while (!stack1.isEmpty() || cur1 != null || !stack2.isEmpty() || cur2 != null) {
            while (cur1 != null) {
                stack1.push(cur1);
                cur1 = cur1.left;
            }
            while (cur2 != null) {
                stack2.push(cur2);
                cur2 = cur2.left;
            }
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.peek().val < stack2.peek().val) {
                    cur1 = stack1.pop();
                    res.add(cur1.val);
                    cur1 = cur1.right;
                } else {
                    cur2 = stack2.pop();
                    res.add(cur2.val);
                    cur2 = cur2.right;
                }
            } else if (!stack1.isEmpty()) {
                cur1 = stack1.pop();
                res.add(cur1.val);
                cur1 = cur1.right;
            } else {
                cur2 = stack2.pop();
                res.add(cur2.val);
                cur2 = cur2.right;
            }
        }
        return res;
    }
}
