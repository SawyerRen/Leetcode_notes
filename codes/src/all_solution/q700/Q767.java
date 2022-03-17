package all_solution.q700;

public class Q767 {
    public String reorganizeString(String s) {
        int maxCount = 0;
        char maxChar = 'a';
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > maxCount) {
                maxChar = c;
                maxCount = count[c - 'a'];
            }
        }
        if (maxCount > (s.length() + 1) / 2) return "";
        int index = 0;
        char[] chars = new char[s.length()];
        while (count[maxChar - 'a'] > 0) {
            chars[index] = maxChar;
            index += 2;
            count[maxChar - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= chars.length) {
                    index = 1;
                }
                chars[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(chars);
    }
}
