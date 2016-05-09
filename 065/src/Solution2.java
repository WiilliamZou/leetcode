public class Solution2 {
    public boolean isNumber(String s) {
        boolean eFound = false;
        boolean eValid = false;
        boolean periodValid = true;
        boolean pmValid = true;
        boolean numberEncountered = false;
        s = s.trim();
        for(char c : s.toCharArray()) {
            if(pmValid) {
                pmValid = false;
                if(c == '+' || c == '-') continue;
            }
            if(eValid && !eFound && c == 'e') {
                eValid = false;
                eFound = true;
                periodValid = false;
                pmValid = true;
                numberEncountered = false;
                continue;
            }
            if(periodValid && c == '.') {
                periodValid = false;
                continue;
            }
            if(c < '0' || c > '9') {
                return false;
            }
            eValid = !eFound;
            numberEncountered = true;
        }
        return numberEncountered;
    }
}