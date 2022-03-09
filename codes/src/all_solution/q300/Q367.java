package all_solution.q300;

public class Q367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (num / mid <= mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * left == num;
    }
}
