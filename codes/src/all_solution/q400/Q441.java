package all_solution.q400;

public class Q441 {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = (1 + mid) * mid / 2;
            if (count == n) return (int) mid;
            if (count > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (right);
    }
}
