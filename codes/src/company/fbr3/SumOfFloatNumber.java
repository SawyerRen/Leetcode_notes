package company.fbr3;

public class SumOfFloatNumber {
    static String solution(String s1, String s2) {
        String[] split1 = s1.split("\\.");
        String[] split2 = s2.split("\\.");
        String sub1 = split1.length == 1 ? "0" : split1[1];
        String sub2 = split2.length == 1 ? "0" : split2[1];
        while (sub1.length() != sub2.length()) {
            if (sub1.length() < sub2.length()) {
                sub1 += "0";
            } else {
                sub2 += "0";
            }
        }
        StringBuilder builder = new StringBuilder();
        int carry = helper(sub1, sub2, builder, 0);
        builder.append(".");
        carry = helper(split1[0], split2[0], builder, carry);
        if (carry > 0) builder.append(carry);
        return builder.reverse().toString();
    }

    private static int helper(String s1, String s2, StringBuilder builder, int carry) {
        int i = s1.length() - 1, j = s2.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return carry;
    }

    public static void main(String[] args) {
        String str1 = "123.52";
        String str2 = "11.2";
        String ans = solution(str1, str2);
        System.out.println(ans);

        //Example 2:
        str1 = "110.75";
        str2 = "9";
        ans = solution(str1, str2);
        System.out.println(ans);
    }
}
