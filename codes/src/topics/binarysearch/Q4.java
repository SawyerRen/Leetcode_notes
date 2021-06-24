package topics.binarysearch;

import java.util.Map;

public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len % 2 == 0) {
            double n1 = findKth(nums1, 0, nums2, 0, len / 2);
            double n2 = findKth(nums1, 0, nums2, 0, len / 2 + 1);
            return (n1 + n2) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    // 找到nums1和nums2从start1和start2开始的第k个数
    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 如果nums1已经找完了，那返回nums2的第k个数
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        // 反之亦然
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        // 如果k=1，就找第一个数
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        // 求nums1和nums2的第k/2个值
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];
        // 如果mid1 < mid2，就舍弃nums1的前k/2个数，反之亦然
        if (mid1 < mid2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
