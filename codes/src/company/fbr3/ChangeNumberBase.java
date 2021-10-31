package company.fbr3;

public class ChangeNumberBase {
    public static String toBase(int value, int targetBase) {
        StringBuilder builder = new StringBuilder();
        while (value != 0) {
            builder.append(value % targetBase);
            value /= targetBase;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(toBase(7, 2));
    }
}
