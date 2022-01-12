package company.fbr5.q700;

import model.TreeNode;

import java.util.*;

public class Q742 {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = find(map, root, k);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left == null && poll.right == null) return poll.val;
            if (poll.left != null && visited.add(poll.left)) {
                queue.add(poll.left);
            }
            if (poll.right != null && visited.add(poll.right)) {
                queue.add(poll.right);
            }
            if (map.containsKey(poll) && visited.add(map.get(poll))) {
                queue.add(map.get(poll));
            }
        }
        return -1;
    }

    private TreeNode find(Map<TreeNode, TreeNode> map, TreeNode root, int k) {
        if (root == null) return null;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        if (root.val == k) {
            return root;
        }
        TreeNode left = find(map, root.left, k);
        if (left != null) return left;
        TreeNode right = find(map, root.right, k);
        if (right != null) return right;
        return null;
    }
}
