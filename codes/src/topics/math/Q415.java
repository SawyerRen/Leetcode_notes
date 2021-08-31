package topics.math;

public class Q415 {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int sum = n1 + n2 + carry;
            builder.insert(0, sum % 10);
            carry = sum / 10;
            index1--;
            index2--;
        }
        return builder.toString();
    }
}
