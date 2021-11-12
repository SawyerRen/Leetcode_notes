package company.fb2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                while (i < nums1.length && nums1[i] == n1) i++;
                while (j < nums2.length && nums2[j] == n2) j++;
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
}
