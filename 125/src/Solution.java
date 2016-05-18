public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        StringBuffer buffer = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c))
                buffer.append(Character.toLowerCase(c));
            else if (Character.isDigit(c))
                buffer.append(c);
        }
        String s2 = buffer.toString();
        return s2.equals(buffer.reverse().toString());
    }
}