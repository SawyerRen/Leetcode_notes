package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        k = arr.length - k;
        for (int i = 0; i < k; i++) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            if (leftDiff <= rightDiff) {
                right--;
            } else {
                left++;
            }
        }
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
