package company.facebook;

public class Q605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int len = flowerbed.length;
        int[] bed = new int[len + 2];
        System.arraycopy(flowerbed, 0, bed, 1, len);
        for (int i = 1; i <= len; i++) {
            if (bed[i - 1] == 0 && bed[i] == 0 && bed[i + 1] == 0) {
                bed[i] = 1;
                n--;
                if (n == 0) return true;
            }
        }
        return false;
    }
}
