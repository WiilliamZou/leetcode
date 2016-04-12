/**
 * Created by yunxiaozou on 4/12/16.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuffer[] buffers = new StringBuffer[numRows];
        for (int i = 0; i < buffers.length; i++) {
            buffers[i] = new StringBuffer();
        }
        boolean direction = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            buffers[count].append(currentChar);
            if (direction) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                count = 1;
                direction = true;
            } else if (count == numRows) {
                count = numRows - 2;
                direction = false;
            }
        }
        StringBuffer output = new StringBuffer();
        for (StringBuffer buffer: buffers) {
            output.append(buffer.toString());
        }
        return output.toString();
    }
}