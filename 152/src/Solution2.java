/**
 * Created by yunxiaozou on 5/22/16.
 */
public class Solution2 {
    public int maxProduct(int[] A) {
        int min;
        int result = A[0], max = min = A[0]; // max, min means max and min product among the subarrays whose last element is A[i].
        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                max = Math.max(max * A[i], A[i]);
                min = Math.min(min * A[i], A[i]);
            }
            else {
                int lastMax = max;
                max = Math.max(min * A[i], A[i]);
                min = Math.min(lastMax * A[i], A[i]);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
