public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        for (int i = 0; i < gas.length; i++) {
            balance = balance + gas[i] - cost[i];
        }
        if (balance < 0) return -1;

        int accumulate = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int currGain = gas[i] - cost[i];
            if (accumulate + currGain < 0) {
                accumulate = 0;
                start = i+1;
            } else {
                accumulate += currGain;
            }
        }
        return start;
    }
}