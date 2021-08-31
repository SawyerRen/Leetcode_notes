package topics.bit_manipulation;

public class Q476 {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n <<= 1;
            n |= 1;
        }
        return n - num;
    }
}
