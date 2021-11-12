package company.fbr5.q400;

public class Q468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".") && valid4(queryIP)) return "IPv4";
        if (queryIP.contains(":") && valid6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean valid6(String queryIP) {
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') return false;
        String[] split = queryIP.split(":");
        if (split.length != 8) return false;
        for (String s : split) {
            if (s.length() == 0 || s.length() > 4) return false;
            for (char c : s.toLowerCase().toCharArray()) {
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) return false;
            }
        }
        return true;
    }

    private boolean valid4(String queryIP) {
        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') return false;
        String[] split = queryIP.split("\\.");
        if (split.length != 4) return false;
        for (String s : split) {
            if (s.length() == 0 || s.length() > 3) return false;
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            if (s.length() > 1 && s.charAt(0) == '0') return false;
            int num = Integer.parseInt(s);
            if (num > 255) return false;
        }
        return true;
    }
}
