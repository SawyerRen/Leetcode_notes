package topics.dp;

public class Q467 {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curLen = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) == -25)) {
                curLen++;
            } else {
                curLen = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], curLen);
        }
        int res = 0;
        for (int c : count) {
            res += c;
        }
        return res;
    }
}
