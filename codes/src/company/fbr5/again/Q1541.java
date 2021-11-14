package company.fbr5.again;

public class Q1541 {
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                right += 2;
                if (right % 2 == 1) {
                    right--;
                    res++;
                }
            } else if (c == ')') {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return res + right;
    }
}
