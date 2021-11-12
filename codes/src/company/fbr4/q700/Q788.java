package company.fbr4.q700;

public class Q788 {
    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            if (valid(i)) res++;
        }
        return res;
    }

    private boolean valid(int num) {
        boolean diff = false;
        while (num != 0) {
            int tail = num % 10;
            if (tail == 2 || tail == 5 || tail == 9 || tail == 6) diff = true;
            else if (tail == 0 || tail == 1 || tail == 8) {
            } else return false;
            num /= 10;
        }
        return diff;
    }
}
