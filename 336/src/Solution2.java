import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yunxiaozou on 6/9/16.
 */
public class Solution2 {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            // Here I take another strategy:
            // add an integer list to each TrieNode;
            // the list will record the indices of all words satisfying the following two conditions:
            // each word has a suffix represented by the current Trie node;
            // the rest of the word forms a palindrome.
            if (root.next[word.charAt(i) - 'a'] == null) {
                root.next[word.charAt(i) - 'a'] = new TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[word.charAt(i) - 'a'];
        }

        root.list.add(index);// empty string is palindrome
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                // found the target.
                list.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            list.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }
}
