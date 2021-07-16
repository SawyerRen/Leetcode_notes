package topics.bit_manipulation;

public class Q201 {
    public int rangeBitwiseAnd(int left, int right) {
        int pos = 0;
        while (left != right) {
            pos++;
            left >>>= 1;
            right >>>= 1;
        }
        return left << pos;
    }
}
