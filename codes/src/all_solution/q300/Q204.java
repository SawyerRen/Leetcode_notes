package all_solution.q300;

public class Q204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i]) continue;
            count++;
            for (int j = 2; j * i < n; j++) {
                notPrime[i * j] = true;
            }
        }
        return count;
    }
}
