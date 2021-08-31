package topics.strings;

public class Q482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        String s1 = s.replace("-", "");
        s1 = s1.toUpperCase();
        char[] chars = s1.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c == '-') continue;
            builder.append(c);
            count++;
            if (count % k == 0 && i != 0) builder.append('-');
        }
        return builder.reverse().toString();
    }
}
