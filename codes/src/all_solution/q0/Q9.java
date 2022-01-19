package all_solution.q0;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int num = 0;
        while (y != 0) {
            int tail = y % 10;
            num = num * 10 + tail;
            y /= 10;
        }
        return x == num;
    }
}
