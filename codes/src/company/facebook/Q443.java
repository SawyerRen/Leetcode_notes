package company.facebook;

public class Q443 {
    public int compress(char[] chars) {
        int resIndex = 0, index = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == c) {
                index++;
                count++;
            }
            chars[resIndex++] = c;
            if (count > 1) {
                for (char c1 : String.valueOf(count).toCharArray()) {
                    chars[resIndex++] = c1;
                }
            }
        }
        return resIndex;
    }
}
