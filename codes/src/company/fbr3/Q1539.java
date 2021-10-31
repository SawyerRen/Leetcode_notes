package company.fbr3;

public class Q1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missing = getMissing(arr, mid);
            if (missing >= k) right = mid;
            else left = mid + 1;
        }
        return right + k;
    }

    int getMissing(int[] arr, int index) {
        return arr[index] - (index + 1);
    }
}
