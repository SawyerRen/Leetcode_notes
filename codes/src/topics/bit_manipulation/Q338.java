package topics.bit_manipulation;

public class Q338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            }
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
