package company.fbr5.q200;

public class Q273 {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int index = 0;
        String s = "";
        while (num != 0) {
            if (num % 1000 != 0) {
                s = helper(num % 1000) + THOUSANDS[index] + " " + s;
            }
            index++;
            num /= 1000;
        }
        return s.trim();
    }

    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
