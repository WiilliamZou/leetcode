import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunxiaozou on 5/9/16.
 */
public class Solution2 {
        public List<String> fullJustify(String[] words, int L) {
            List<String> lines = new ArrayList<String>();

            int index = 0;
            while (index < words.length) {
                int count = words[index].length();
                int next = index + 1;
                while (next < words.length) {
                    if (words[next].length() + count + 1 > L) break;
                    count += words[next].length() + 1;
                    next++;
                }
                //index means the first word in current line, next-1 means the last word in current line.

                StringBuilder builder = new StringBuilder();
                int numWords = next - index - 1;
                // if next line or number of words in the line is 1, left-justified
                if (next == words.length || numWords == 0) {
                    for (int i = index; i < next; i++) {
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
                    for (int i = index; i < next; i++) {
                        builder.append(words[i]);
                        if (i < next - 1) {
                            for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                                builder.append(" ");
                            }
                        }
                    }
                }
                lines.add(builder.toString());
                index = next;
            }


            return lines;
        }

}
