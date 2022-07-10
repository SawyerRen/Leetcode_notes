package ng2022.q0;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0;
        int temp = x;
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp /= 10;
        }
        return x == y;
    }
}
