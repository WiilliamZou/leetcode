/**
 * Created by yunxiaozou on 5/23/16.
 */
public class Solution02 extends Reader4 {

    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == 0) {
                buffCnt = read4(buff);
            }
            if (buffCnt == 0) break;
            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) {
                buffPtr = buffCnt = 0;
            }
        }
        return ptr;
    }

}
