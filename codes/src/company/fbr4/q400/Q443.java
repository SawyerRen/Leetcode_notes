package company.fbr4.q400;

public class Q443 {
    public int compress(char[] chars) {
        int resIndex = 0, index = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == c) {
                count++;
                index++;
            }
            chars[resIndex++] = c;
            if (count > 1) {
                String s = String.valueOf(count);
                for (int i = 0; i < s.length(); i++) {
                    chars[resIndex++] = s.charAt(i);
                }
            }
        }
        return resIndex;
    }
}
