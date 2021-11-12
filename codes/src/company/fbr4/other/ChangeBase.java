package company.fbr4.other;

public class ChangeBase {
    static String changeBase(int num, int base) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(num % base);
            num /= base;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(changeBase(12, 7));
        System.out.println(changeBase(12, 5));
        System.out.println(changeBase(12, 2));
    }
}
