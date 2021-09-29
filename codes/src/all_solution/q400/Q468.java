package all_solution.q400;

public class Q468 {
    public String validIPAddress(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == ':' || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == ':' || IP.charAt(IP.length() - 1) == '.')
            return "Neither";
        String[] split = IP.split("\\.");
        if (split.length == 4) {
            return validIPv4(split);
        } else {
            split = IP.split(":");
            if (split.length == 8) {
                return validIPv6(split);
            }
        }
        return "Neither";
    }

    private String validIPv6(String[] split) {
        for (String s : split) {
            if (s.length() < 1 || s.length() > 3) return "Neither";
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) continue;
                if (Character.isLetter(c)) {
                    if ('a' <= c && c <= 'f' || 'A' <= c && c <= 'F') {
                    } else return "Neither";
                }
            }
        }
        return "IPv6";
    }

    private String validIPv4(String[] split) {
        for (String s : split) {
            if (s.length() == 0 || s.length() > 3) return "Neither";
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) return "Neither";
                if (i > 0 && s.charAt(0) == '0') return "Neither";
            }
            int i = Integer.parseInt(s);
            if (i < 0 || i > 255) return "Neither";
        }
        return "IPv4";
    }
}
