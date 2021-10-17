package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        int n = arr.length;
        k = n - k;
        for (int i = 0; i < k; i++) {
            int leftDiff = Math.abs(arr[l] - x);
            int rightDiff = Math.abs(arr[r] - x);
            if (leftDiff <= rightDiff) {
                r--;
            } else {
                l++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
