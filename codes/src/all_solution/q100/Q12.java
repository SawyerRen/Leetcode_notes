package all_solution.q100;

public class Q12 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (num != 0) {
            while (num >= nums[index]) {
                builder.append(roman[index]);
                num -= nums[index];
            }
            index++;
        }
        return builder.toString();
    }
}
