package company.fbr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge3Lists {
    static int[] merge(int[] l1, int[] l2, int[] l3) {
        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();
        while (i < l1.length || j < l2.length || k < l3.length) {
            int n1 = i == l1.length ? Integer.MAX_VALUE : l1[i];
            int n2 = j == l2.length ? Integer.MAX_VALUE : l2[j];
            int n3 = k == l3.length ? Integer.MAX_VALUE : l1[k];
            int min = Math.min(n1, Math.min(n2, n3));
            list.add(min);
            if (min == n1) i++;
            if (min == n2) j++;
            if (min == n3) k++;
        }
        int[] res = new int[list.size()];
        for (int l = 0; l < res.length; l++) {
            res[l] = list.get(l);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] l1 = {0, 10, 21, 23, 28};
        int[] l2 = {10, 12, 24, 28, 50};
        int[] l3 = {-1, 12, 21, 29};
        int[] merge = merge(l1, l2, l3);
        System.out.println(Arrays.toString(merge));
    }
}
