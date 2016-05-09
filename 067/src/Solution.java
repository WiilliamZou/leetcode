public class Solution {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.max(a.length(), b.length()) || carry != 0; i++) {
            int digitA = (i < a.length()) ? a.charAt(i)-'0' : 0;
            int digitB = (i < b.length()) ? b.charAt(i)-'0' : 0;
            int temp = digitA + digitB + carry;
            if (temp >= 2) {
                temp -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(temp);
        }
        return  sb.reverse().toString();
    }
}