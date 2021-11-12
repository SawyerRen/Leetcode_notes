package company.fbr5.q300;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (builder.length() > 0 && count[builder.charAt(builder.length() - 1) - 'a'] > 0 &&
                    c < builder.charAt(builder.length() - 1)) {
                visited[builder.charAt(builder.length() - 1) - 'a'] = false;
                builder.setLength(builder.length() - 1);
            }
            builder.append(c);
            visited[c - 'a'] = true;
        }
        return builder.toString();
    }
}
