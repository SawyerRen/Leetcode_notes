package company.fbfinal;

public class Q932 {
    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
            return res;
        }
        int[] odd = beautifulArray((n + 1) / 2);
        int i = 0;
        for (int v : odd) {
            res[i++] = v * 2 - 1;
        }
        int[] even = beautifulArray(n / 2);
        for (int v : even) {
            res[i++] = v * 2;
        }
        return res;
    }
}
