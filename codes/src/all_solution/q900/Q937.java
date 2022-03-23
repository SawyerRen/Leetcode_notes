package all_solution.q900;

import java.util.Arrays;

public class Q937 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] split1 = a.split(" ", 2);
            String[] split2 = b.split(" ", 2);
            boolean digit1 = Character.isDigit(split1[1].charAt(0));
            boolean digit2 = Character.isDigit(split2[1].charAt(0));

            if (!digit1 && !digit2) {
                int res = split1[1].compareTo(split2[1]);
                if (res == 0) return split1[0].compareTo(split2[0]);
                else return res;
            } else if (digit1 && digit2) {
                return 0;
            } else if (digit1) {
                return 1;
            } else {
                return -1;
            }
        });
        return logs;
    }
}
