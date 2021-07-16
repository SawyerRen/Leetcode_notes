package topics.design;

public class Q307 {
}

class NumArray {
    class SegmentNode {
        int sum;
        int start;
        int end;
        SegmentNode left;
        SegmentNode right;

        public SegmentNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    SegmentNode root = null;

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    private SegmentNode buildSegmentTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentNode root = new SegmentNode(start, end);
        if (start == end) {
            root.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            root.left = buildSegmentTree(nums, start, mid);
            root.right = buildSegmentTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(SegmentNode root, int index, int val) {
        if (root == null) return;
        if (root.start == root.end && root.start == index) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= index) {
            update(root.left, index, val);
        } else {
            update(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private int sumRange(SegmentNode root, int left, int right) {
        if (root.start == left && root.end == right) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if (right <= mid) {
            return sumRange(root.left, left, right);
        } else if (left > mid) {
            return sumRange(root.right, left, right);
        } else {
            return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
        }
    }
}