package company.facebook;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (index >= word.length()) return false;
            char c = abbr.charAt(i);
            if (c == '0') return false;
            if ('0' <= c && c <= '9') {
                int num = c - '0';
                while (i + 1 < abbr.length() && Character.isDigit(abbr.charAt(i + 1))) {
                    num = num * 10 + abbr.charAt(i + 1) - '0';
                    i++;
                }
                index += num;
                if (index > word.length()) return false;
            } else {
                if (word.charAt(index) != abbr.charAt(i)) return false;
                index++;
            }
        }
        return index == word.length();
    }
}
