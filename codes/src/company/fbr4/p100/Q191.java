package company.fbr4.p100;

public class Q191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
