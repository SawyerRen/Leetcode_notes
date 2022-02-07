package all_solution.q100;

public class Q168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber != 0) {
            builder.append((char) (--columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return builder.reverse().toString();
    }
}
