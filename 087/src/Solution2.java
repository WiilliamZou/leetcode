public class Solution2 {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len!=s2.length()) return false;
        if(len==0) return true;
        boolean[][][] isScr = new boolean[len][len][len];
        for(int i = 0; i < len; i++) { //length of current substring, 0 means length==1
            for(int j = 0; j + i < len; j++) { //start point of current substring at s1.
                for(int k = 0; k + i < len; k++) { //start point of current substring at s2.
                    if(i==0) isScr[i][j][k] = s1.charAt(j)==s2.charAt(k);
                    for(int m = 0; m < i; m++) {
                        if(isScr[m][j][k] && isScr[i-(m+1)][j+m+1][k+m+1]) isScr[i][j][k] = true;
                        else if(isScr[m][j][k+i-m] && isScr[i-(m+1)][j+m+1][k]) isScr[i][j][k] = true;
                    }
                }
            }
        }
        return isScr[len-1][0][0];
    }
}