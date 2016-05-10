public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.isEmpty()) return word2.length();
        if (word2 == null || word2.isEmpty()) return word1.length();
        return 0;
    }
}