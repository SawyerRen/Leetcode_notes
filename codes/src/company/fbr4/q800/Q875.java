package company.fbr4.q800;

public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 0;
            for (int pile : piles) {
                need += (pile - 1) / mid + 1;
            }
            if (need <= h) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
