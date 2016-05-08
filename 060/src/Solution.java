import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        if (n < 1 || k < 1) return "";
        int[] fact = new int[n+1];
        int sum = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            fact[i] = sum;
            sum *= (i+1);
            if (i > 0)
                numbers.add(i);
        }

        k--;
        for (int i = 1; i <= n; i++) {
            int index = k/fact[n-i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * fact[n-i];
        }
        return sb.toString();
    }
}