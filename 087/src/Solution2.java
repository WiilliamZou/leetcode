public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len!=s2.length()) return false;
        if(len==0) return true;
        boolean[][][] isScr = new boolean[len][len][len];
        for(int l = 0; l < len; l++) { //length of current substring, 0 means length==1
            for(int i = 0; i + l < len; i++) { //start point of current substring at s1.
                for(int j = 0; j + l < len; j++) { //start point of current substring at s2.
                    if(l==0) isScr[l][i][j] = s1.charAt(i)==s2.charAt(j);
                    for(int m = 0; m < l; m++) {
                        if(isScr[m][i][j] && isScr[l-(m+1)][i+m+1][j+m+1]) isScr[l][i][j] = true;
                        else if(isScr[m][i][j+l-m] && isScr[l-(m+1)][i+m+1][j]) isScr[l][i][j] = true;
                    }
                }
            }
        }
        return isScr[len-1][0][0];
    }
}