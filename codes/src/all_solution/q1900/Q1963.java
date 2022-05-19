package all_solution.q1900;

public class Q1963 {
    public int minSwaps(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                left++;
            } else {
                if (left > 0) left--;
                else right++;
            }
        }
        return (right + 1) / 2;
    }
}
