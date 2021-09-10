package all_solution.q300;

import java.util.ArrayList;
import java.util.List;

public class Q241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer l : left) {
                    for (Integer r : right) {
                        switch (c) {
                            case '+' -> res.add(l + r);
                            case '-' -> res.add(l - r);
                            case '*' -> res.add(l * r);
                            case '/' -> res.add(l / r);
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
