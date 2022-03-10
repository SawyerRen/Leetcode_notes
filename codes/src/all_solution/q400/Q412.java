package all_solution.q400;

import java.util.ArrayList;
import java.util.List;

public class Q412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        int fizz = 0, buzz = 0;
        for (int i = 1; i < n + 1; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
