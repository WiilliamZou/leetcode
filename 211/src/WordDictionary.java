import java.util.HashMap;
import java.util.Iterator;

public class WordDictionary {
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ws.children.containsKey(c)) {
                ws.children.put(c, new TrieNode(c));
            }
            ws = ws.children.get(c);
        }
        ws.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (node == null) return false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                Iterator<TrieNode> iter = node.children.values().iterator();
                while (iter.hasNext()) {
                    if (search(word.substring(i+1), iter.next())) return true;
                }
                return false;
            } else {
                if (!node.children.containsKey(c)) return false;
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }

    private class TrieNode {
        public char val;
        public boolean isWord;
        public HashMap<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char c) {this.val = c;}
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");