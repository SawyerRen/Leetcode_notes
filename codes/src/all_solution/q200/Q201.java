package all_solution.q200;

public class Q201 {
    public int rangeBitwiseAnd(int left, int right) {
        int pos = 0;
        while (left != right) {
            left >>>= 1;
            right >>>= 1;
            pos++;
        }
        return left << pos;
    }
}
