package company.fbr4.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeThreeArrays {
    static int[] merge(int[] num1, int[] nums2, int[] nums3) {
        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();
        while (i < num1.length || j < nums2.length || k < nums3.length) {
            int n1 = i < num1.length ? num1[i] : Integer.MAX_VALUE;
            int n2 = j < nums2.length ? nums2[j] : Integer.MAX_VALUE;
            int n3 = k < nums3.length ? nums3[k] : Integer.MAX_VALUE;
            int min = Math.min(n1, Math.min(n2, n3));
            list.add(min);
            while (i < num1.length && num1[i] == min) i++;
            while (j < nums2.length && nums2[j] == min) j++;
            while (k < nums3.length && nums3[k] == min) k++;
        }
        int[] res = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            res[l] = list.get(l);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 10, 12, 21, 21, 22};
        int[] nums2 = {0, 9, 10, 23};
        int[] nums3 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(merge(nums1, nums2, nums3)));
    }
}
