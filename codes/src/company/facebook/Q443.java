package company.facebook;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0, resIndex = 0;
        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[resIndex++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[resIndex++] = c;
                }
            }
        }
        return resIndex;
    }
}
