package ng2022.q100;

public class Q190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int right = n & 1;
            n >>= 1;
            res <<= 1;
            res |= right;
        }
        return res;
    }
}
