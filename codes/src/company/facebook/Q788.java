package company.facebook;

public class Q788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (valid(i)) res++;
        }
        return res;
    }

    private boolean valid(int num) {
        boolean res = false;
        while (num != 0) {
            int tail = num % 10;
            if (tail == 2 || tail == 5 || tail == 6 || tail == 9) res = true;
            if (tail == 3 || tail == 4 || tail == 7) return false;
            num /= 10;
        }
        return res;
    }
}
