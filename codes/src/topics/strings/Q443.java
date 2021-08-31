package topics.strings;

public class Q443 {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char leftChar = chars[i];
            int count = 0;
            while (i < chars.length && leftChar == chars[i]) {
                i++;
                count++;
            }
            chars[index++] = leftChar;
            if (count != 0) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}
