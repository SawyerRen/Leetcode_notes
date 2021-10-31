package company.fbr3;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0, resIndex = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && c == chars[index]) {
                count++;
                index++;
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
