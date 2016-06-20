import java.util.Random;

public class Solution4 {
    private void shuffle(int a[]) {

        final Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        shuffle(nums);
        return findKth(nums, 0, nums.length-1, nums.length-k+1);
    }
    private int findKth(int[] nums, int lo, int hi, int k) {
        if (lo == hi) return nums[lo];
        int i = lo, j = hi+1;
        int v = nums[lo];
        while (true) {
            while(i < hi && nums[++i] < v);
            while(j > lo && v < nums[--j]);
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        if (j-lo+1 == k) return v;
        else if (j-lo+1 > k) return findKth(nums, lo, j-1, k);
        else return findKth(nums, j+1, hi, k-(j-lo+1));
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}