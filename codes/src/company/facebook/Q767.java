package company.facebook;

public class Q767 {
    public String reorganizeString(String s) {
        int max = 0;
        int maxIndex = -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                max = count[c - 'a'];
                maxIndex = c - 'a';
            }
        }
        if (max > (s.length() + 1) / 2) return "";
        char[] res = new char[s.length()];
        int index = 0;
        while (count[maxIndex] > 0) {
            res[index] = (char) (maxIndex + 'a');
            index += 2;
            count[maxIndex]--;
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }
}
