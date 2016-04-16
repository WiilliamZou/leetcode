/**
 * Created by yunxiaozou on 4/15/16.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 */
public class Solution {
    public String countAndSay(int n) {
        if (n < 1)
            return "";
        return countAndSay(n, "");
    }

    private String countAndSay(int n, String s) {
        if (n == 0) return s;
        if (s == "") return countAndSay(n-1, "1");
        StringBuffer newStringBuffer = new StringBuffer();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            int count = 1;
            i++;
            while (i < s.length() && s.charAt(i) == c) {
                count++;
                i++;
            }
            newStringBuffer.append(count);
            newStringBuffer.append(c);
        }
        return countAndSay(n-1, newStringBuffer.toString());
    }
}