package all_solution.q600;

public class Q605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeros = 1, count = 0;
        for (int pos : flowerbed) {
            if (pos == 0) {
                zeros++;
            } else {
                count += (zeros - 1) / 2;
                zeros = 0;
            }
        }
        if (zeros > 0) count += zeros / 2;
        return count >= n;
    }
}
