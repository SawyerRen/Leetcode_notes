package company.fbr5.other;

import java.util.ArrayList;
import java.util.List;

public class MergeThreeArrays {
    List<Integer> merge(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length || k < nums3.length) {
            int n1 = i < nums1.length ? nums1[i] : Integer.MAX_VALUE;
            int n2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            int n3 = k < nums3.length ? nums3[k] : Integer.MAX_VALUE;
            int min = Math.min(n1, Math.min(n2, n3));
            res.add(min);
            while (i < nums1.length && nums1[i] == min) i++;
            while (j < nums2.length && nums2[j] == min) j++;
            while (k < nums3.length && nums3[k] == min) k++;
        }
        return res;
    }
}
