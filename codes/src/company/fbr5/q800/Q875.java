package company.fbr5.q800;

import java.util.Map;

public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int pile : piles) {
                count += (pile - 1) / mid + 1;
            }
            if (count <= h) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
