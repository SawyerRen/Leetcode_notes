package company.fbr5.q1100;

public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            boolean valid = true;
            int[] count1 = new int[26];
            for (char c : word.toCharArray()) {
                count1[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (count1[i] > count[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res += word.length();
        }
        return res;
    }
}
