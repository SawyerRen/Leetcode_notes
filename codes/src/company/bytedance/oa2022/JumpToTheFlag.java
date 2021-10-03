package company.bytedance.oa2022;

public class JumpToTheFlag {
    static int minJump(int flagHeight, int bigJump) {
        int res = flagHeight / bigJump;
        int remain = flagHeight % bigJump;
        return res + remain;
    }

    public static void main(String[] args) {
        System.out.println(minJump(8, 3));
    }
}
