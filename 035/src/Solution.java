public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0)
            return -1;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}