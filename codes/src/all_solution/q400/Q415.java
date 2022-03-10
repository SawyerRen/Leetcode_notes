package all_solution.q400;

public class Q415 {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = v1 + v2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }
}
