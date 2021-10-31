package company.facebook;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int i = 0, j = 0;
        int maxCount = 0, res = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            maxCount = Math.max(maxCount, count[rc - 'A']);
            if (j - i + 1 - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
