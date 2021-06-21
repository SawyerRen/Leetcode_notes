package topics.math;

public class Q43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2;
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i : pos) {
            if (i == 0 && builder.length() == 0) continue;
            builder.append(i);
        }
        if (builder.length() == 0) return "0";
        return builder.toString();
    }
}
