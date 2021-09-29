package company.pimco;

/*
decrypt字母。字母全都是大写，给一个encrypted string一个int，int就是字母要往前推多少个。比如string是CDEF而int给的2，那decode出来就是ABCD，
每个字母往前推了2。k可以很大很大，我是用char和ascii code做的，中间就有一个while loop不停加26。k一定大于零所以只会往前推
 */
public class Q6 {
    static String solution(String s, int k) {
        k %= 26;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - k >= 'A') chars[i] -= k;
            else chars[i] += 26 - k;
        }
        return new String(chars);
    }
}
