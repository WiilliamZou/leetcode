public class Solution {
    public boolean isNumber(String s) {
        if (s == null ) return false;
        s = s.trim();
        boolean hasFirst, hasDot, hasDigit, hasE;
        hasDigit = hasFirst = hasDot = hasE = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                hasFirst = hasDigit = true;
            } else {
                switch (c) {
                    case '+':
                    case '-':
                        if (hasFirst) {
                            return false;
                        }
                        hasFirst = true;
                        break;
                    case '.':
                        if (hasDot)
                            return false;
                        hasDot = true;
                        hasFirst = true;
                        break;
                    case 'e':
                        if (hasE || !hasDigit)
                            return false;
                        hasE = true;
                        hasDigit = false;
                        hasDot = true;
                        hasFirst = false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return hasDigit;
    }
}