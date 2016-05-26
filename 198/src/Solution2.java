public class Solution2 {
    public int rob(int[] nums) {
    /*
    Dynamic programming
    Bottom-up approach
    Since we cannot rob 2 adjacent houses, generally, we cannot rob house[n] and house [n-1] at the same night
    So the basic idea is to see if house[n-1] has been robbed
    If house[n-1] has been robbed, then the optimal approach should be max{robbedmoney(n-1), robbedmoney(n-2)+nums[n]}
    If house[n-1] hasn't been robbed, then the optimal approach should be robbedmoney(n-2)+nums[n]
    */

        int l = nums.length;
        if (l == 0){
            return 0;
        }

        int[] robbedmoney = new int[l]; //robbedmoney[i] array is used to store the maximum amount of money that can be robbed from the first i houses.
        for (int i = 0; i < l; i ++){
            if (i == 0){
                robbedmoney[i] = nums[i];
            }
            else if (i == 1){
                robbedmoney[i] = Math.max(nums[i], nums[i-1]);
            }
            else{
                robbedmoney[i] = Math.max(robbedmoney[i - 2] + nums[i], robbedmoney[i-1]);
            }
        }

        return robbedmoney[l - 1];

    }
}