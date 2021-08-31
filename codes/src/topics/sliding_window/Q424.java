package topics.sliding_window;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxCount = 0;
        int[] hash = new int[26];
        int left = 0, right = 0;
        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, hash[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
