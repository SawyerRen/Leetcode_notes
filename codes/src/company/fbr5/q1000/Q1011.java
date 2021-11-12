package company.fbr5.q1000;

public class Q1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 1, load = 0;
            for (int weight : weights) {
                if (load + weight > mid) {
                    load = 0;
                    need++;
                }
                load += weight;
            }
            if (need <= days) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
