package topics.bit_manipulation;

public class Q461 {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n >>>= 1;
        }
        return res;
    }
}
