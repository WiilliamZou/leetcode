/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int left = 0;
        int right = n - 1;
        if (n == 1) return n;
        while (left < right) {
            boolean k1 = knows(left, right);
            boolean k2 = knows(right, left);
            if (!(k1 ^ k2)) {
                left++;
                right--;
            } else if (k1) {
                left++;
            } else {
                right--;
            }
        }
        if (left != right) return -1;
        for (int i = 0; i < n; i++) {
            if (i == left) continue;
            if (!knows(i, left) || knows(left, i)) return -1;
        }
        return left;
    }
}