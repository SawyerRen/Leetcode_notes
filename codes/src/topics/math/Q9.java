package topics.math;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int y = 0;
        while (temp != 0) {
            int tail = temp % 10;
            y = y * 10 + tail;
            temp /= 10;
        }
        return x == y;
    }
}
