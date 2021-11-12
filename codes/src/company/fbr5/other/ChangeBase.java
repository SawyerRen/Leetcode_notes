package company.fbr5.other;

public class ChangeBase {
    static String changeBase(int num, int base) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(num % base);
            num /= base;
        }
        return builder.reverse().toString();
    }
}
