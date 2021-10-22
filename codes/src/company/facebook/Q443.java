package company.facebook;

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
                for (int j = 0; j < s.length(); j++) {
                    chars[resIndex++] = s.charAt(j);
                }
            }
        }
        return resIndex;
    }
}
