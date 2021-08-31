package topics.two_pointer;

public class Q345 {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowel(chars[i])) i++;
            while (i < j && !isVowel(chars[j])) j--;
            if (i < j) {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
