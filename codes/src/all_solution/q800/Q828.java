package all_solution.q800;

public class Q828 {
    public int uniqueLetterString(String s) {
        int[] contribution = new int[26];
        int[] lastOccur = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            contribution[c - 'A'] = i + 1 - lastOccur[c - 'A'];
            int cur = 0;
            for (int j = 0; j < 26; j++) {
                cur += contribution[j];
            }
            res += cur;
            lastOccur[c - 'A'] = i + 1;
        }
        return res;
    }
}
