package company.fbr4.q300;

import java.util.*;

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            int n1 = nums1[i], n2 = nums2[j];
            if (n1 == n2) {
                list.add(n1);
                while (i < nums1.length && n1 == nums1[i]) i++;
                while (j < nums2.length && n2 == nums2[j]) j++;
            } else if (n1 < n2) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) nums.add(i);
        }
        int[] res = new int[nums.size()];
        int index = 0;
        for (Integer num : nums) {
            res[index++] = num;
        }
        return res;
    }
}
