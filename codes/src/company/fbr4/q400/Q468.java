package company.fbr4.q400;

public class Q468 {
    public String validIPAddress(String IP) {
        if (IP.contains(".") && validIPv4(IP)) return "IPv4";
        else if (IP.contains(":") && validIPv6(IP)) return "IPv6";
        else return "Neither";
    }

    private boolean validIPv6(String ip) {
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') return false;
        String[] split = ip.split(":");
        if (split.length != 8) return false;
        for (String s : split) {
            if (s.length() == 0 || s.length() > 4) return false;
            for (char c : s.toLowerCase().toCharArray()) {
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) return false;
            }
        }
        return true;
    }

    private boolean validIPv4(String ip) {
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') return false;
        String[] split = ip.split("\\.");
        if (split.length != 4) return false;
        for (String s : split) {
            if (s.length() == 0 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)) {
                return false;
            }
            for (char c : s.toCharArray()) {
                if (c < '0' || c > '9') return false;
            }
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }
}
