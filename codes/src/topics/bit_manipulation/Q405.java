package topics.bit_manipulation;

import java.util.List;

public class Q405 {
    public String toHex(int num) {
        String[] strs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        StringBuilder builder = new StringBuilder();
        if (num == 0) return "0";
        while (num != 0) {
            int index = num & 0b1111;
            builder.insert(0, strs[index]);
            num >>>= 4;
        }
        return builder.toString();
    }
}
