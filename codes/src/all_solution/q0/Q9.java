package all_solution.q0;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return y == temp;
    }
}
