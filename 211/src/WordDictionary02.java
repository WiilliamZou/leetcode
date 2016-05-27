/**
 * Created by yunxiaozou on 5/27/16.
 */
public class WordDictionary02 {
    WordNode root = new WordNode();
    public void addWord(String word) {
        char[]  chars = word.toCharArray();
        addWord(chars, 0, root);
    }

    private void addWord(char[] chars, int index, WordNode parent) {
        char c = chars[index];
        int idx = c-'a';
        WordNode node = parent.children[idx];
        if (node == null) {
            node = new WordNode();
            parent.children[idx] = node;
        }
        if (chars.length == index+1) {
            node.isWord = true;
            return;
        }
        addWord(chars, ++index, node);
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }

    private boolean search(char[] chars, int index, WordNode parent) {
        if (index == chars.length) return parent.isWord;

        char c = chars[index];
        if (c == '.') {
            for (WordNode next: parent.children) {
                if (next != null) {
                    if (search(chars, index+1, next)) return true;
                }
            }
            return false;
        } else {
            WordNode next = parent.children[c-'a'];
            if (next == null) {
                return false;
            } else {
                return search(chars, index+1, next);
            }
        }
    }

    private class WordNode {
        boolean isWord;
        WordNode[] children = new WordNode[26];
    }
}
