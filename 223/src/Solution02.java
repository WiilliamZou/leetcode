/**
 * Created by yunxiaozou on 5/28/16.
 */
public class Solution02 {
    public int computeArea(int A, int B, int C, int D,
                           int E, int F, int G, int H) {
        int rectOne = (C-A) * (D-B);
        int rectTwo = (G-E) * (H-F);

        if (A >= G || E >= C ||
                B >= H || F >= D) {
           return  rectOne + rectTwo;
        }
        int length = Math.min(C,G) - Math.max(A,E);
        int height = Math.min(D,H) - Math.max(B,F);

        return rectOne + rectTwo - length * height;
    }
}
