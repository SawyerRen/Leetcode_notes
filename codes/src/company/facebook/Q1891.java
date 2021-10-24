package company.facebook;

public class Q1891 {
    public int maxLength(int[] ribbons, int k) {
        int left = 1, right = 0;
        for (int ribbon : ribbons) {
            right = Math.max(ribbon, right) + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int ribbon : ribbons) {
                count += ribbon / mid;
            }
            if (count < k) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }
}
