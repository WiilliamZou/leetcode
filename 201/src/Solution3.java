public class Solution3 {
    public int rangeBitwiseAnd(int m, int n) {
        int count=0;
        while(m!=n) {
            // 得到共同的'头部'
            // 得到 [m, n] 中每一个数的共同头部
            m=m>>>1; //shift numbers right
            n=n>>>1; //shift numbers right
            count=count+1; //keep track of Shifts
        }
        return n<<count; //do left shifts with 0 padding and return answer.
    }
}