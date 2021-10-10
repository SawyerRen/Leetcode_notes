package company.codesignal.quora;

public class ExchangeStringIndex {
    static String solution(String input) {
        char[] chars = input.toCharArray();
        if (input.length() == 1 || input.length() == 0) return input;
        for (int i = 0; i < chars.length; i += 2) {
            if (i + 1 == chars.length) break;
            char t = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = t;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(solution("12345"));
    }
}
