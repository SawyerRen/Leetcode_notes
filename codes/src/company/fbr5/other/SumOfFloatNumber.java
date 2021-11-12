package company.fbr5.other;

public class SumOfFloatNumber {
    static String getSum(String s1, String s2) {
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
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        carry = addHelper(sub1, sub2, builder, carry);
        builder.append(".");
        carry = addHelper(split1[0], split2[0], builder, carry);
        if (carry != 0) builder.append(carry);
        return builder.reverse().toString();
    }

    private static int addHelper(String sub1, String sub2, StringBuilder builder, int carry) {
        int i = sub1.length() - 1, j = sub2.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? sub1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? sub2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            builder.append(sum % 10);
            i--;
            j--;
        }
        return carry;
    }

    public static void main(String[] args) {
        String str1 = "123.52";
        String str2 = "11.2";
        String ans = getSum(str1, str2);
        System.out.println(ans);

        //Example 2:
        str1 = "110.75";
        str2 = "9";
        ans = getSum(str1, str2);
        System.out.println(ans);
    }
}
