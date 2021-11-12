package company.fbr4.q900;

import java.util.LinkedList;
import java.util.List;

public class Q989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        String s = String.valueOf(k);
        int i = num.length - 1, j = s.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num[i] : 0;
            int n2 = j >= 0 ? s.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            res.addFirst(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return res;
    }
}
