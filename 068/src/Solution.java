import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int first = 0;
        while (first < words.length) {
            int next = first + 1;
            int count = words[first].length();
            // count the next
            // 每一行至少有一个元素.
            while (next < words.length) {
                if (count + words[next].length() + 1 > maxWidth) break;
                count = words[next].length() + 1;
                next++;
            }
            StringBuilder builder = new StringBuilder();
            int numSlots = next - 1 - first; // numSlots is the number of space slots  - 1.

        }

        return lines;
    }
}