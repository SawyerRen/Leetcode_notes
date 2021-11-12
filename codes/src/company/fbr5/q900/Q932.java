package company.fbr5.q900;

public class Q932 {
    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
            return res;
        }
        int[] odd = beautifulArray((n + 1) / 2);
        int index = 0;
        for (int i : odd) {
            res[index++] = i * 2 - 1;
        }
        int[] even = beautifulArray(n / 2);
        for (int i : even) {
            res[index++] = i * 2;
        }
        return res;
    }
}
