public class NumArray {
    private long[] sum;
    public NumArray(int[] nums) {
        sum = new long[nums.length];
        long temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            sum[i] = temp;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return (int)sum[j];
        else {
            return (int) (sum[j] - sum[i-1]);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);