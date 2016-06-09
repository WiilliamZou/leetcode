/**
 * Created by yunxiaozou on 6/8/16.
 */
public class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        int length1EndHere = Integer.MAX_VALUE;
        int length2EndHere = Integer.MAX_VALUE;
        for(int i=0, N=nums.length; i<N; i++) {
            if(nums[i] > length2EndHere) return true;
            else if(nums[i] > length1EndHere) length2EndHere = Math.min(nums[i], length2EndHere);
            else length1EndHere = nums[i];
        }
        return false;
    }
}
