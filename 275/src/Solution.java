import java.util.Arrays;

/**
 * Created by yunxiaozou on 6/2/16.
 */
public class Solution {
    public int hIndex(int[] citations) {
        int i = 0 ;
        while (i < citations.length && citations[citations.length-1-i] > i) {
            i++;
        }
        return i;
    }

}
