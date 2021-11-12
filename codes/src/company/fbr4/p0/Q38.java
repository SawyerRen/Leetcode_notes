package company.fbr4.p0;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder builder = new StringBuilder();
        String pre = countAndSay(n - 1);
        for (int i = 0; i < pre.length(); i++) {
            char num = pre.charAt(i);
            int count = 1;
            while (i + 1 < pre.length() && pre.charAt(i + 1) == num) {
                count++;
                i++;
            }
            builder.append(count).append(num);
        }
        return builder.toString();
    }
}
