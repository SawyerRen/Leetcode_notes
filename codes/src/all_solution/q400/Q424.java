package all_solution.q400;

public class Q424 {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0, res = 0, max = 0;
        int[] count = new int[26];
        while (j < s.length()) {
            char rc = s.charAt(j);
            count[rc - 'A']++;
            max = Math.max(count[rc - 'A'], max);
            while (j - i + 1 - max > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
