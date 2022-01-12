package company.ffff;

public class Q1047 {
    public String removeDuplicates(String s) {
        char[] res = new char[s.length()];
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

    public String removeDuplicates1(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (builder.length() > 0 && builder.charAt(builder.length() - 1) == c) {
                builder.setLength(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
