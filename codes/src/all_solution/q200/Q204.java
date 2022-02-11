package all_solution.q200;

public class Q204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) continue;
            res++;
            for (int j = 2; j * i < n; j++) {
                notPrime[i * j] = true;
            }
        }
        return res;
    }
}
