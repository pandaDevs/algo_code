package code;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                node.push(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);

        return node != null & node.isEnd();
    }

    public boolean startWiths(String word) {
        TrieNode node = searchPrefix(word);

        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if(!node.containsKey(ch)) {
                return null;
            }

            node = node.get(ch);
        }
        return node;
    }
}

