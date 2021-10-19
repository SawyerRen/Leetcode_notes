package company.facebook;

public class Q788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (valid(i)) res++;
        }
        return res;
    }

    private boolean valid(int n) {
        boolean valid = false;
        while (n > 0) {
            int tail = n % 10;
            if (tail == 2 || tail == 5 || tail == 6 || tail == 9) valid = true;
            else if (tail == 3 || tail == 4 || tail == 7) return false;
            n /= 10;
        }
        return valid;
    }
}
