package company.fbr4.q1200;

public class Q1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 0, right = 0;
        for (int i : sweetness) {
            right += i;
        }
        right++;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0, cur = 0;
            for (int i : sweetness) {
                cur += i;
                if (cur >= mid) {
                    count++;
                    cur = 0;
                }
            }
            if (count < k + 1) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }
}
