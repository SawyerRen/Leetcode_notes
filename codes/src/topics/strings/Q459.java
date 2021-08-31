package topics.strings;

public class Q459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length() / 2; len++) {
            if (s.length() % len != 0) continue;
            int start = 0;
            String sub = s.substring(start, start + len);
            while (start < s.length()) {
                String nextSub = s.substring(start, start + len);
                if (!sub.equals(nextSub)) break;
                start += len;
            }
            if (start >= s.length()) return true;
        }
        return false;
    }
}
