package all_solution.q200;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q173 {

}

class BSTIterator {
    List<Integer> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        buildList(root);
    }

    private void buildList(TreeNode root) {
        if (root == null) return;
        buildList(root.left);
        list.add(root.val);
        buildList(root.right);
    }

    public int next() {
        if (hasNext()) return list.get(index++);
        return -1;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}