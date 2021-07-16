package topics.bit_manipulation;

public class Q231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}
