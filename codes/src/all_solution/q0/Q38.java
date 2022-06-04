package all_solution.q0;

public class Q38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder builder = new StringBuilder();
        String pre = countAndSay(n - 1);
        char c = pre.charAt(0);
        int count = 0;
        for (char c1 : pre.toCharArray()) {
            if (c == c1) {
                count++;
            } else {
                builder.append(count).append(c);
                c = c1;
                count = 1;
            }
        }
        builder.append(count).append(c);
        return builder.toString();
    }
}
