package karat.other;

import java.util.HashMap;
import java.util.Map;

/*
You're creating a game with some amusing mini-games, and you've decided to make a simple variant of the game Mahjong.
In this variant, players have a number of tiles, each marked 0-9. The tiles can be grouped into pairs or triples of the same tile.
For example, if a player has "33344466", the player's hand has a triple of 3s, a triple of 4s, and a pair of 6s.
Similarly, "55555777" has a triple of 5s, a pair of 5s, and a triple of 7s.

A "complete hand" is defined as a collection of tiles where all the tiles can be grouped into any number of triples (zero or more) and exactly one pair, and each tile is used in exactly one triple or pair.
Write a function that takes a string representation of a collection of tiles in no particular order, and returns true or false depending on whether or not the collection represents a complete hand.

N - Number of tiles in the input string
tiles1 = "11133555" # True. 111 33 555
tiles2 = "111333555" # False. There are three triples, 111 333 555 but no pair.
tiles3 = "00000111" # True. 000 00 111. Your pair and a triplet can be of the same value
# There is also no limit to how many of each tile there is.
tiles4 = "13233121" # True. Tiles are not guaranteed to be in order
tiles5 = "11223344555" # False. There cannot be more than one pair
tiles6 = "99999999" # True. You can have many of one tile
tiles7 = "999999999" # False.
tiles8 = "9" # False.
tiles9 = "99" # True.
tiles10 = "000022" # False.
tiles11 = "221" # False. There cannot be any tiles left over.
tiles12 = "889" # False. There cannot be any tiles left over.

completeHand(tiles1) => True
completeHand(tiles2) => False
completeHand(tiles3) => True
completeHand(tiles4) => True
completeHand(tiles5) => False
completeHand(tiles6) => True
completeHand(tiles7) => False
completeHand(tiles8) => False
completeHand(tiles9) => True
completeHand(tiles10) => False
completeHand(tiles11) => False
completeHand(tiles12) => False
*/
public class Q5 {
    boolean completeHand(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, (map.getOrDefault(c, 0) + 1) % 3);
        }
        boolean foundPair = false;
        for (Character c : map.keySet()) {
            if (map.get(c) == 0) continue;
            if (map.get(c) == 2) {
                if (foundPair) return false;
                foundPair = true;
            }
        }
        return foundPair;
    }

    static boolean res = false;

    static boolean competeHand2(String tiles) {
        int[] hash = new int[10];
        for (char c : tiles.toCharArray()) {
            hash[c - '0']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] < 2) continue;
            hash[i] -= 2;
            helper(hash);
            hash[i] += 2;
        }
        return res;
    }

    private static void helper(int[] hash) {
        if (valid(hash)) {
            res = true;
            return;
        }
        for (int i = 0; i < hash.length - 2; i++) {
            if (hash[i] == 0 || hash[i + 1] == 0 || hash[i + 2] == 0) continue;
            hash[i]--;
            hash[i + 1]--;
            hash[i + 2]--;
            helper(hash);
            hash[i]++;
            hash[i + 1]++;
            hash[i + 2]++;
        }
    }

    private static boolean valid(int[] hash) {
        for (int v : hash) {
            if (v % 3 != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(competeHand2("00890"));
    }
}
