package topics.hashtable;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];
        for (char c : magazine.toCharArray()) {
            hash[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            hash[c - 'a']--;
            if (hash[c - 'a'] < 0) return false;
        }
        return true;
    }
}
