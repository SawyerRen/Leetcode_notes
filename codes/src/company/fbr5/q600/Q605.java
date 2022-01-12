package company.fbr5.q600;

public class Q605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        int count = 0, cur = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                cur++;
            } else {
                count += (cur - 1) / 2;
                cur = 0;
            }
        }
        if (cur > 0) cur++;
        count += (cur - 1) / 2;
        return count >= n;
    }
}
