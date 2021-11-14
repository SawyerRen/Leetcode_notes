package company.fbfinal;

public class Q415 {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }
}
