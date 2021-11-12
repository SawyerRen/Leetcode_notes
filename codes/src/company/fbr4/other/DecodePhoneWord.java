package company.fbr4.other;

import java.util.ArrayList;
import java.util.List;

public class DecodePhoneWord {
    static String[] strings = {"Z", "ABC", "DEF", "GHI", "JKL", "MNO", "PQO", "ST", "UVW", "XY"};

    static List<String> decodePhoneWord(int[] decodeArr) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), decodeArr, 0, 0);
        return res;
    }

    private static void helper(List<String> res, StringBuilder builder, int[] decodeArr, int index, int count) {
        if (index == decodeArr.length) {
            res.add(builder.toString());
            return;
        }
        String s = strings[decodeArr[index]];
        if (index + 1 < decodeArr.length && decodeArr[index] == decodeArr[index + 1]) {
            helper(res, builder, decodeArr, index + 1, count + 1);
        }
        builder.append(s.charAt(count % s.length()));
        helper(res, builder, decodeArr, index + 1, 0);
        builder.setLength(builder.length() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        List<String> list = decodePhoneWord(arr);
        System.out.println(list);
    }
}
