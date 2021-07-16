package topics.math;

public class Q204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) continue;
            for (int j = 2; j * i < n; j++) {
                notPrime[i * j] = true;
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) res++;
        }
        return res;
    }
}
