package company.fbr5.q1000;

public class Q1047 {
    public String removeDuplicates(String s) {
        int[] res = new int[s.length()];
        int end = -1;
        for (char c : s.toCharArray()) {
            if (end >= 0 && c == res[end]) {
                end--;
            } else {
                res[++end] = c;
            }
        }
        return new String(res, 0, end + 1);
    }
}
