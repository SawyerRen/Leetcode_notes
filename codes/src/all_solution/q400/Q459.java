package all_solution.q400;

public class Q459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = n / 2; len >= 1; len--) {
            if (n % len == 0) {
                StringBuilder builder = new StringBuilder();
                String sub = s.substring(0, len);
                builder.append(sub.repeat(n / len));
                if (s.equals(builder.toString())) return true;
            }
        }
        return false;
    }
}
