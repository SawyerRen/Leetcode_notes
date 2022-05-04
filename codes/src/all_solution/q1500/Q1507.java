package all_solution.q1500;

public class Q1507 {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        int day = 0;
        for (int i = 0; i < split[0].length(); i++) {
            if (!Character.isDigit(split[0].charAt(i))) break;
            day = day * 10 + split[0].charAt(i) - '0';
        }
        String dd = day < 10 ? "0" + day : String.valueOf(day);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int month = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(split[1])) month = i + 1;
        }
        String mm = month < 10 ? "0" + month : String.valueOf(month);
        return split[2] + "-" + mm + "-" + dd;
    }
}
