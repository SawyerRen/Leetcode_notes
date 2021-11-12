package company.fbr4.again;

public class Q1541 {
    public int minInsertions(String s) {
        int right = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                right += 2;
                if (right % 2 == 1) {
                    right--;
                    res++;
                }
            } else {
                right--;
                if (right < 0) {
                    res++;
                    right += 2;
                }
            }
        }
        return res + right;
    }
}
