package topics.math;

public class Q372 {
    public int superPow(int a, int[] b) {
        return sub(a, b, b.length - 1);
    }

    private int sub(int a, int[] b, int index) {
        if (index == 0) return pow(a, b[index]) % 1337;
        int pre = sub(a, b, index - 1);
        return pow(pre, 10) * pow(a, b[index]) % 1337;
    }

    private int pow(int a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a % 1337;
        int half = pow(a, n / 2);
        if (n % 2 == 0) {
            return half * half % 1337;
        } else {
            return (half * half) % 1337 * (a % 1337) % 1337;
        }
    }
}
