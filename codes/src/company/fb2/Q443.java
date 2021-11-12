package company.fb2;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0, resIndex = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == c) {
                index++;
                count++;
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
