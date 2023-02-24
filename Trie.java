import java.util.ArrayList;

public class Trie {
    static String Alphabet = "abcdefghijklmnopqrstuvwxyz";

    static TrieNode trieroot = new TrieNode();
    public ArrayList<String> answers = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */

    /**
     * Inserts a word into the trie.
     */
    public void insert(String key)                                            //insert restaurant name into trie tree
    {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = trieroot;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }


    //    public void insert(String word) {
//        TrieNode curNode = root;
//        char[] arr = word.toCharArray();
//        for (char curChar : arr) {
//            if (!curNode.children.containsKey(curChar)) {
//                curNode.children.put(curChar, new TrieNode());
//            }
//            curNode = curNode.children.get(curChar);
//        }
//        curNode.isWord = true;
//    }

    /**
     * Returns if the word is in the trie.
     */
//    public java.util.Map<Character, TrieNode> search(String word) {
//        TrieNode curNode = root;
//        char[] arr = word.toCharArray();
//        for (char curChar : arr) {
//            if (!curNode.children.containsKey(curChar)) {
////                return false;
//                System.out.println("Ridi!!!!!!!");
//            }
//            curNode = curNode.children.get(curChar);
//        }
//        return curNode.children;
//    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
//    public java.util.Map<Character, TrieNode> startsWith(String prefix) {
//        TrieNode curNode = root;
//        char[] arr = prefix.toCharArray();
//        for (char curChar : arr) {
//            if (!curNode.children.containsKey(curChar)) {
//                System.out.println("Ridi!!!!!!!");
//                return null;
//            }
//            curNode = curNode.children.get(curChar);
//        }
//        return curNode.children;
//    }
    static void searchTrie(String key) {                         //search trie tree for restaurant with
        TrieNode pCrawl = trieroot;                                                 //prefix key
        String name = "";

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                System.out.println("NO restaurant found!");
                return;
            }
            name = name + Alphabet.charAt(index);
            pCrawl = pCrawl.children[index];
        }

        while (pCrawl != null && !pCrawl.isEndOfWord) {
            int j = 0;
            while (pCrawl.children[j] == null) {
                j++;
            }
            name = name + Alphabet.charAt(j);
            if (pCrawl.children[j].isEndOfWord)
                break;
            pCrawl = pCrawl.children[j];
        }

        System.out.println(name);
    }

    static boolean isEmpty(TrieNode root)                                       //check is the root empty
    {
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    public TrieNode removeTrie(TrieNode root, String key, int depth)         //remove restaurant from trie tree
    {
        if (root == null)
            return null;
        if (depth == key.length()) {

            if (root.isEndOfWord)
                root.isEndOfWord = false;

            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }
        int index = key.charAt(depth) - 'a';
        root.children[index] = removeTrie(root.children[index], key, depth + 1);
        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

//    public void display(String prefix) {
//        if (startsWith(prefix) != null){
//            prefix
//        }
//    }


}
