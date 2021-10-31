package company.fbr3;

public class Q1047 {
    public String removeDuplicates(String s) {
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
