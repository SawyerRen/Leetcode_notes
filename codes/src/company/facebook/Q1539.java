package company.facebook;

public class Q1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingCount = arr[mid] - mid - 1;
            if (missingCount >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + k;
    }
}
