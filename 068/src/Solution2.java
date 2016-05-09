import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/9/16.
 */
public class Solution2 {
        public List<String> fullJustify(String[] words, int L) {
            List<String> lines = new ArrayList<String>();
            int first = 0;
            while (first < words.length) {
                // count is the space of [word[first], ... ,word[next-1]]
                int count = words[first].length();
                int next = first + 1;
                while (next < words.length) {
                    if (count + words[next].length() + 1 > L) break;
                    count += words[next].length() + 1;
                    next++;
                }
                StringBuilder builder = new StringBuilder();
                int numWords = next - first - 1;
                // if next line or number of words in the line is 1, left-justified
                if (next == words.length || numWords == 0) {
                    for (int i = first; i < next; i++) {
                        builder.append(words[i] + " ");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    for (int i = builder.length(); i < L; i++) {
                        builder.append(" ");
                    }
                } else {
                    // middle justified
                    int spaces = (L - count) / numWords;
                    int r = (L - count) % numWords;
                    for (int i = first; i < next; i++) {
                        builder.append(words[i]);
                        if (i < next - 1) {
                            for (int j = 0; j <= (spaces + ((i - first) < r ? 1 : 0)); j++) {
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
