/**
 * Created by yunxiaozou on 6/5/16.
 */
public class NumArray03 {
    int[] tree;
    int[] numbers;
    int m;
    public NumArray03(int[] nums) {
        if (nums.length == 0) return;
        m = nums.length;
        tree = new int[m+1];
        numbers = new int[m];
        for (int i = 0; i < m; i++) {
            update(i, nums[i]);
        }
    }

    void update(int index, int val) {
        if (m == 0) return;
        int delta = val - numbers[index];
        numbers[index] = val;
        for (int i = index+1; i <= m; i += i & (-i)) {
            tree[i] += delta;
        }

    }

    public int sumRange(int i, int j) {
        if (m == 0);
        return sum(j+1) - sum(i);
    }
    public int sum(int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
