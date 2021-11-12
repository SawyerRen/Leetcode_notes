package company.fbr5.q700;

public class Q788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (valid(i)) res++;
        }
        return res;
    }

    private boolean valid(int num) {
        boolean valid = false;
        while (num != 0) {
            int tail = num % 10;
            if (tail == 2 || tail == 5 || tail == 6 || tail == 9) valid = true;
            if (tail == 3 || tail == 4 || tail == 7) return false;
            num /= 10;
        }
        return valid;
    }
}
