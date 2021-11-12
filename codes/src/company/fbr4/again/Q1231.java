package company.fbr4.again;

public class Q1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1, right = 0;
        for (int i : sweetness) {
            right += i;
        }
        right++;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int part = 0, count = 0;
            for (int i : sweetness) {
                part += i;
                if (part >= mid) {
                    part = 0;
                    count++;
                }
            }
            if (count < k + 1) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }
}
