import java.util.Scanner;

class Student {
    static int enrollmentNumber = 1;
    private final String name;
    private final int EN = enrollmentNumber;

    public Student(String name) {
        this.name = name;
        enrollmentNumber++;
    }

    @Override
    public String toString() {
        return EN + ": " + name;
    }
}

public class Solution{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println(work(args));
        } catch (Exception e) {
            System.out.println("exec");
        }
        work(args);
    }

    static int work(String[] args) {
        return Integer.parseInt(args[0]);
    }
}
