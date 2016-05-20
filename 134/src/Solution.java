public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        int max = -1;
        int local = 0;
        int index = -1;
        int localIndex = -1;
        if (gas == null || cost == null || cost.length != gas.length) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            balance += gain;
            if (gain >= 0) {
                if (local == 0) {
                    localIndex = i;
                }
                local += gain;
                if (max < local){
                    max = local;
                    index = localIndex;
                }
            } else {
                local = 0;
            }
        }
        if (gas.length > 1) {
            int gain = gas[0] - cost[0];
            if (gain >= 0) {
                local += gain;
                if (max < local) {
                    max = local;
                    index = localIndex;
                }
            }
        }
        if (balance < 0) return -1;
        else return index;
    }
}