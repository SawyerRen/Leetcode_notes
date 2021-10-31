package company.facebook.freq;

public class Q1047 {
    public String removeDuplicates1(String s) {
        char[] res = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            res[index] = s.charAt(i);
            if (index > 0 && res[index] == res[index - 1]) {
                index--;
            } else {
                index++;
            }
        }
        return new String(res, 0, index);
    }

    public String removeDuplicates(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (builder.length() > 0 && c == builder.charAt(builder.length() - 1)) {
                builder.setLength(builder.length() - 1);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
