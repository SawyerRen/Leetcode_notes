package all_solution.q0;

public class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int reverseNum = 0;
        int temp = x;
        while (temp != 0) {
            int tail = temp % 10;
            reverseNum = reverseNum * 10 + tail;
            temp /= 10;
        }
        return reverseNum == x;
    }
}
