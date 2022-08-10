package ng2022.oa.amazon.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Q1 was about given an Array of numbers, for example {5, 1, 2, 1, 4, 5} which represent skills of employees..(Skills[i])
 * How many teams you can form, given the Teamsize = 3 and MaxDiff = 2 which is the maximum difference allowed in skills
 * <p>
 * Example 1 = With {5, 1, 2, 1, 4, 5} and given Teamsize = 3 and MaxDiff = 2. You can form 2 teams [2, 1, 1] and [4, 5, 5].
 * Example 2 : 0 teams can be formed with [9, 3, 5, 7, 1] and int teamSize = 2; int maxDiff = 1
 */

public class CountMaximumTeams {
    public static int solution(int[] skills, int teamSize, int maxDiff) {
        Arrays.sort(skills);
        int res = 0;
        int index = 0;
        while (index + teamSize <= skills.length) {
            if (skills[index + teamSize - 1] - skills[index] <= maxDiff) {
                res++;
                index += teamSize;
            } else {
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 2, 1, 4, 5}, 3, 2));
        System.out.println(solution(new int[]{9, 3, 5, 7, 1}, 2, 1));
    }
}
