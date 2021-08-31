package topics.strings;

public class Q434 {
    public int countSegments(String s) {
        if (s.trim().equals("")) return 0;
        return s.trim().split(" +").length;
    }
}
