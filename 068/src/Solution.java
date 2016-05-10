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
            if (next == words.length || numSlots == 0) {
                for (int i = first; i < next; i++) {
                    builder.append(words[i]);
                    if (i < next-1)
                        builder.append(" ");
                }

                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                int spacesPerSlot = (maxWidth - count) / numSlots;
                int remain = (maxWidth - count) % numSlots;
                for (int i = first; i < next; i++) {
                    builder.append(words[i]);
                    if (i < next-1) {
                        // at least 1 space per slot.
                        for (int j = 0; j <= (spacesPerSlot + (i-first) < remain ? 1 : 0); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            first = next;
        }

        return lines;
    }
}