package company.facebook;

import org.xml.sax.ext.Locator2;

public class Q1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getMissing(arr, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return left + k;
    }

    int getMissing(int[] nums, int index) {
        return nums[index] - (index + 1);
    }
}
