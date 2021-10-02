package company.bytedance.interview;

/*
rearrange string
 */
public class Q15 {
    static int rearrangeString(String s, String[] w) {
        String s1 = s.toLowerCase();
        int[] hash = new int[26];
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }
        for (String word : w) {
            if (valid(hash, word)) return 1;
        }
        return 0;
    }

    private static boolean valid(int[] hash, String word) {
        int[] hash2 = new int[26];
        String s = word.toLowerCase();
        for (char c : s.toCharArray()) {
            hash2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] < hash2[i]) return false;
        }
        return true;
    }
}
