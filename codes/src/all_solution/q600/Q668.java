package all_solution.q600;

public class Q668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = getCount(mid, m, n);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int getCount(int mid, int m, int n) {
        int i = m, j = 1;
        int count = 0;
        while (i >= 1 && j <= n) {
            int num = i * j;
            if (num <= mid) {
                count += i;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
