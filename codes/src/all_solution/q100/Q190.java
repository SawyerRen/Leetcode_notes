package all_solution.q100;

public class Q190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            int tail = n & 1;
            res |= tail;
            n >>= 1;
        }
        return res;
    }
}
