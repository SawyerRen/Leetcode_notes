package company.facebook;

public class Q387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
