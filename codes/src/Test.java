import javax.sound.midi.Soundbank;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        int[] arr = {44, 78, 13, 55, 21, 96, 78, 89, 51, 80, 100, 98, 66, 18, 3, 17, 75, 60, 42, 15, 1, 34, 63, 52, 7, 96, 98, 13, 76, 84, 66, 35, 7, 8, 1, 89};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
