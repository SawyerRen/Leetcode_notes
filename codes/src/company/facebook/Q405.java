package company.facebook;

public class Q405 {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(map[num & 15]);
            num >>>= 4;
        }
        return builder.reverse().toString();
    }
}
