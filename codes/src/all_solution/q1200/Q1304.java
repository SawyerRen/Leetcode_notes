package all_solution.q1200;

public class Q1304 {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        if (n % 2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) res[i] = (i + 2) / 2;
                else res[i] = -(i + 2) / 2;
            }
        } else {
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) res[i] = i / 2;
                else res[i] = -(i + 1) / 2;
            }
        }
        return res;
    }
}
