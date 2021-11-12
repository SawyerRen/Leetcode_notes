package company.fbr5.q700;

public class Q767 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxCount = 0;
        char maxChar = 'a';
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > maxCount) {
                maxCount = count[c - 'a'];
                maxChar = c;
            }
        }
        if (maxCount > (s.length() + 1) / 2) return "";
        int index = 0;
        char[] res = new char[s.length()];
        while (count[maxChar - 'a'] > 0) {
            res[index] = maxChar;
            index += 2;
            count[maxChar - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= s.length()) index = 1;
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
}
