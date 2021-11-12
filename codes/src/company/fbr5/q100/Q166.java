package company.fbr5.q100;

import java.util.HashMap;
import java.util.Map;

public class Q166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) builder.append("-");
        long absNum = Math.abs((long) numerator);
        long absDen = Math.abs((long) denominator);
        builder.append(absNum / absDen);
        absNum = absNum % absDen;
        if (absNum == 0) return builder.toString();
        builder.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(absNum, builder.length());
        while (absNum != 0) {
            builder.append(absNum * 10 / absDen);
            absNum = absNum * 10 % absDen;
            if (map.containsKey(absNum)) {
                Integer index = map.get(absNum);
                builder.insert(index, "(");
                builder.append(")");
                return builder.toString();
            }
            map.put(absNum, builder.length());
        }
        return builder.toString();
    }
}
