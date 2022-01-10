class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Trie trie = new Trie();
        
        for (String word: startWords) {
            int len = word.length();
            int[] count = new int[26];
            
            for (int i = 0; i < len; ++ i) {
                count[word.charAt(i) - 'a'] = 1;
            }
            
            trie.insert(count);
        }
        
        int output = 0;
        for (String word: targetWords) {
            int len = word.length();
            
            int[] count = new int[26];
            for (int i = 0; i < len; ++ i) {
                count[word.charAt(i) - 'a'] = 1;
            }
            
            for (int i = 0; i < 26; ++ i) {
                if (count[i] == 0) {
                    continue;
                }
                count[i] = 0;
                if (trie.search(count)) {
                    ++ output;
                    break;
                }
                count[i] = 1;
            }
        }
        
        return output;
    }
    
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void insert(int[] arr) {
            TrieNode ptr = root;
            for (int i = 0; i < 26; ++ i) {
                if (ptr.children[arr[i]] == null) {
                    ptr.children[arr[i]] = new TrieNode();
                }
                ptr = ptr.children[arr[i]];
            }
        }
        
        boolean search(int[] arr) {
            TrieNode ptr = root;
            for (int i = 0; i < 26; ++ i) {
                if (ptr.children[arr[i]] == null) {
                    return false;
                }
                ptr = ptr.children[arr[i]];
            }
            
            return true;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }
}