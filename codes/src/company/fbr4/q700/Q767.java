package company.fbr4.q700;

public class Q767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int max = 0;
        char maxChar = 'a';
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                max = count[c - 'a'];
                maxChar = c;
            }
        }
        if (max > (s.length() + 1) / 2) return "";
        int index = 0;
        char[] chars = new char[s.length()];
        while (count[maxChar - 'a'] > 0) {
            chars[index] = maxChar;
            index += 2;
            count[maxChar - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= s.length()) index = 1;
                chars[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(chars);
    }
}
