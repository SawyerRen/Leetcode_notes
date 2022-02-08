package all_solution.q100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q173 {

}

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        buildStack(root);
    }

    private void buildStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        if (!hasNext()) return -1;
        TreeNode pop = stack.pop();
        buildStack(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}