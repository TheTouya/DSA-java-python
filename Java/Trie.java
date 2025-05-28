public class Trie {
    private class TrieNode {
        TrieNode[] chars;
        boolean last_word;
        public TrieNode() {
            chars = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String key) {
        TrieNode temp = root;
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.chars[index] == null) {
                TrieNode nd = new TrieNode();
                temp.chars[index] = nd;
            }
            temp = temp.chars[index];
        }
        temp.last_word = true;
    }
    public boolean search(String key) {
        TrieNode temp = root;
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(temp.chars[index] == null) {
                return false;
            }
            temp = temp.chars[index];
        }
        return temp.last_word;
    }
    public boolean isPrefix(String key) {
        TrieNode temp = root;
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(temp.chars[index] == null) {
                return false;
            }
            temp = temp.chars[index];
        }
        return true;
    }
}
