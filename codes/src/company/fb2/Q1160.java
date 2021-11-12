package company.fb2;

public class Q1160 {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        boolean valid = true;
        for (String word : words) {
            int[] count1 = new int[26];
            for (char c : word.toCharArray()) {
                count1[c - 'a']++;
                if (count1[c - 'a'] > count[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid) res += word.length();
            valid = true;
        }
        return res;
    }
}
