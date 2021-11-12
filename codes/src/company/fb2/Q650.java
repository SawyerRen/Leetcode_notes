package company.fb2;

public class Q650 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] bed = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            bed[i + 1] = flowerbed[i];
        }
        if (n == 0) return true;
        for (int i = 1; i < bed.length - 1; i++) {
            if (bed[i - 1] == 0 && bed[i] == 0 && bed[i + 1] == 0) {
                n--;
                if (n == 0) return true;
                bed[i] = 1;
            }
        }
        return false;
    }
}
