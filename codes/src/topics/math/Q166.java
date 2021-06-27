package topics.math;

import java.util.HashMap;
import java.util.Map;

public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder builder = new StringBuilder();
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) builder.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        builder.append(num / den);
        if (num % den == 0) return builder.toString();
        num %= den;
        builder.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, builder.length());
        while (num != 0) {
            num *= 10;
            builder.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                builder.insert(map.get(num), "(").append(")");
                return builder.toString();
            }
            map.put(num, builder.length());
        }
        return builder.toString();
    }
}
