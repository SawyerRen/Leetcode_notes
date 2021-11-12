package company.fbr4.q1100;

public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] count1 = new int[26];
            for (char c : word.toCharArray()) {
                count1[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] < count1[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res += word.length();
        }
        return res;
    }
}
