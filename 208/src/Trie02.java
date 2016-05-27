

import java.util.HashMap;

/**
 * Created by yunxiaozou on 5/27/16.
 */
public class Trie02 {
    private class TrieNode {
        public char val;
        public boolean isWord;
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char c) {
            this.val = c;
        }
    }

    private TrieNode root;
    public Trie02() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ws.children.containsKey(c))
                ws.children.put(c, new TrieNode(c));
            ws = ws.children.get(c);
        }
        ws.isWord = true;
    }

    public TrieNode searchNode (String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ws.children.containsKey(c)) return null;
            ws = ws.children.get(c);
        }
        return ws;
    }
    public boolean search (String word) {
        TrieNode node = searchNode(word);
        if (node == null || !node.isWord) return false;
        else return true;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

}
