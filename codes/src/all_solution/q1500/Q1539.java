package all_solution.q1500;

public class Q1539 {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getMissing(arr, mid);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left + k;
    }

    private int getMissing(int[] arr, int index) {
        return arr[index] - index - 1;
    }
}
