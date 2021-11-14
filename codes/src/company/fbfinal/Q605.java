package company.fbfinal;

public class Q605 {
    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0, cur = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                cur++;
            } else {
                count += (cur - 1) / 2;
                cur = 0;
            }
        }
        if (cur > 0) count += cur / 2;
        return count >= n;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) return true;
        int[] newBed = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, newBed, 1, flowerbed.length);
        for (int i = 1; i < newBed.length - 1; i++) {
            if (newBed[i - 1] == 0 && newBed[i] == 0 && newBed[i + 1] == 0) {
                n--;
                newBed[i] = 1;
                if (n == 0) return true;
            }
        }
        return false;
    }
}
