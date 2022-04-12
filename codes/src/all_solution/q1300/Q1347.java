package all_solution.q1300;

public class Q1347 {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] > 0) count[c - 'a']--;
            else res++;
        }
        return res;
    }
}
