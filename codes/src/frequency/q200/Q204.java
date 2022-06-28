package frequency.q200;

public class Q204 {
    public int countPrimes(int n) {
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
