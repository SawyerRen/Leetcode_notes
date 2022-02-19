package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        switch (c) {
                            case '+' -> res.add(left + right);
                            case '-' -> res.add(left - right);
                            case '*' -> res.add(left * right);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
