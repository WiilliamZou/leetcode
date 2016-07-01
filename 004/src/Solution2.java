/**
 * Created by yunxiaozou on 12/28/15.
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ((m+n)%2 == 1) {
            return findKth(nums1, nums2, (m+n)/2+1, 0, m-1);
        } else {
            return (findKth(nums1, nums2, (m+n)/2, 0, m-1) +
                    findKth(nums1, nums2, (m+n)/2+1, 0, m-1)) * 0.5;
        }
        // 1-based.
    }

    private int findKth(int[] A, int[] B, int k, int p, int q) {
        int m = A.length;
        int n = B.length;
        if (p > q)
            return findKth(B, A, k, 0, n-1);
        int i = p+(q-p)/2;
        int j = k-1-i-1;
        // i+1 + j+1 = k

        if ((j < 0 || (j < n && A[i] >= B[j]))
                && (j+1 >= n || (j+1 >= 0 && A[i] <= B[j+1]))) {
            return A[i];
        } else if (j + 1 < 0 || (j+1 < n && A[i] > B[j+1])) {
            return findKth(A, B, k, p, i-1);
        } else {
            return findKth(A, B, k, i+1, q);
        }
    }
}