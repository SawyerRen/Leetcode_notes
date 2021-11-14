package company.fbfinal;

public class Q1541 {
    public int minInsertions(String s) {
        int add = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                right += 2;
                if (right % 2 == 1) {
                    right--;
                    add++;
                }
            } else if (c == ')') {
                right--;
                if (right < 0) {
                    right += 2;
                    add++;
                }
            }
        }
        return add + right;
    }
}
