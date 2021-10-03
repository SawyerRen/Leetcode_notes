package company.bytedance.oa2022;

public class FizzBuzz {
    static void solution(int n) {
        int num1 = 3, num2 = 5;
        for (int i = 1; i <= n; i++) {
            if (i == num1 && i == num2) {
                System.out.println("FizzBuzz");
                num1 += 3;
                num2 += 5;
            } else if (i == num1) {
                System.out.println("Fizz");
                num1 += 3;
            } else if (i == num2) {
                System.out.println("Buzz");
                num2 += 5;
            } else {
                System.out.println(i);
            }
        }
    }
}
