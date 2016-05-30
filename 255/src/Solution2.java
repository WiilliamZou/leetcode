public class Solution2 {
    public boolean verifyPreorder(int[] preorder) {
        int index = -1;
        int flag = Integer.MIN_VALUE;
        for (int num: preorder) {
            if (num < flag) return false;
            while (index != -1 && preorder[index] < num) {
                flag = preorder[index--];
            }
            preorder[++index] = num;
        }
        return true;
    }
}