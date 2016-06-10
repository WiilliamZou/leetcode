public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            while (left < arr.length && !isVowel(arr, left))
                left++;
            while (right >= 0 && !isVowel(arr, right))
                right--;
            if (left < right) {
                swap(arr, left++, right--);
            }
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isVowel(char[] arr, int i) {
        char c = arr[i];
        c = Character.toLowerCase(c);
        if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u')
            return true;
        else return false;
    }


}