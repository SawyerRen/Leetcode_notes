package all_solution.q0;

public class Q6 {
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < builders.length; i++) {
            builders[i] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                builders[i].append(s.charAt(index));
                index++;
            }
            for (int i = numRows - 2; i >= 1 && index < s.length(); i--) {
                builders[i].append(s.charAt(index));
                index++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : builders) {
            res.append(builder);
        }
        return res.toString();
    }
}
