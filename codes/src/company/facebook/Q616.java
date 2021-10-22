package company.facebook;

public class Q616 {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        int end = 0;
        boolean[] bold = new boolean[n];
        for (int i = 0; i < s.length(); i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            if (end > i) bold[i] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) builder.append(s.charAt(i));
            else {
                builder.append("<b>");
                int j = i + 1;
                while (j < s.length() && bold[j]) j++;
                builder.append(s.substring(i, j));
                builder.append("</b>");
                i = j - 1;
            }
        }
        return builder.toString();
    }
}
