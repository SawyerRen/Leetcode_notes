package topics.math;

import java.util.LinkedList;

public class Q67 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        if (m == 0) return b;
        if (n == 0) return a;
        int i = m - 1, j = n - 1;
        int carry = 0;
        LinkedList<String> list = new LinkedList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int val1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 2;
            list.addFirst(String.valueOf(sum % 2));
            i--;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }
}
