package topics.bit_manipulation;

public class Q190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int right = n & 1;
            res <<= 1;
            res |= right;
            n >>= 1;
        }
        return res;
    }
}
