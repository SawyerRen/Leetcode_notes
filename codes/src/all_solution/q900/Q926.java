package all_solution.q900;

public class Q926 {
    public int minFlipsMonoIncr(String s) {
        int flips = 0;
        int countOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') countOnes++;
            else {
                // flip ones to zero
                int step1 = countOnes;
                // flip this zero to one
                int step2 = flips + 1;
                flips = Math.min(step1, step2);
            }
        }
        return flips;
    }
}
