package company.codesignal;

/*
reduceTheNumber , 输入一串数字和k，要求先将数字按顺序k个k个地进行分组，多出来的自成一组，每组求和之后合并成新的数字，知道数字的size小于k,
1112223331, k = 3, ->111,222,333,1->3691-> 3+6+9, 1 -> 181
 */
public class ReduceTheNumber {
    static int solution(int num, int k) {
        String s = String.valueOf(num);
        if (s.length() < k) return Integer.parseInt(s);
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int n = 0;
            int count = 0;
            while (i < s.length() && count < k) {
                n += s.charAt(i) - '0';
                i++;
                count++;
            }
            builder.append(n);
        }
        return solution(Integer.parseInt(builder.toString()), k);
    }

    public static void main(String[] args) {
        System.out.println(solution(1112223331, 3));
    }
}
