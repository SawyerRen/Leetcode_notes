package company.fbr5.q400;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0, resIndex = 0;
        while (index < chars.length) {
            char c = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == c) {
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
