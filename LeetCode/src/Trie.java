/*Problem Statement: IMPLEMENT TRIE (Prefix tree)

Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

*/

/*THEORY:
    Trie is a prefix tree where in you can store words having same prefix together. Here words having same prefixes have a common parent node.

    A node is a basic entity in trie tree and each node in consists of 3 things:
    1. Character value - to store the character
    2. An array of Trie Nodes having a length of 26 - to store each child node for that node (26 is the length because we have 26 characters)
    3. A boolean variable (is_a_word) = setting this as true implies that all the nodes above this node including this node, form a complete word. False implies that this is just a pattern in the tree and not a complete word

    And since each tree has a root, trie also has this single node 'root' as its member.
*/

public class Trie {

    TrieNode root=null;  // trie tree's root

    class TrieNode       // each node in the trie tree
    {
        char val;
        TrieNode[] alphabets=new TrieNode[26];
        boolean is_a_word=false;
    }

    /** Initialize your data structure here. */

    public Trie() {
        root=new TrieNode();
        root.val='-';
    }

    /** Inserts a word into the trie. */

    public void insert(String word) {
        TrieNode current=root;          // begin with root
        for(int i=0;i<word.length();i++)
        {
                if(current.alphabets[(word.charAt(i)-'a')]==null)  // if the position for that character in the alphabets array is null, it means that character is not present in that tree, hence we add it to the tree
                {
                    TrieNode newTrieNode=new TrieNode();            // Suppose we want to  add char 'c' to the tree, its position is given by Ascii subtraction 'c' - 'a' = 99-97 = 2. So 2 is the index position for character 'c' to be stored
                    newTrieNode.val=word.charAt(i);
                    current.alphabets[(word.charAt(i)-'a')]=newTrieNode;  // we add this new node at the respective character's position
                    if(i==word.length()-1)              // if this is the last letter in the word to be inserted then set is_a_word as true whichmeans this is the end of the word
                        newTrieNode.is_a_word=true;
                    else
                        newTrieNode.is_a_word=false;
                    current=newTrieNode;              // we move to the next node
                }
                else    // if the character is already present
                {
                    if(i==word.length()-1)                                    // if this is the last letter then set is_a_word of this character's node as true
                        current.alphabets[word.charAt(i)-'a'].is_a_word=true;
                    else
                        current=current.alphabets[(word.charAt(i)-'a')];      // move to the next node (i.e current character's node)
                }

        }

    }

    /** Returns if the word is in the trie. */

    public boolean search(String word) {
        TrieNode current=root;
        for(int i=0;i<word.length();i++)
        {
            if(current.alphabets[word.charAt(i)-'a']==null)   // if the character to be searched is not present , return false
                return false;
            else
            {
                if(current.alphabets[word.charAt(i)-'a']!=null && i==(word.length()-1) && current.alphabets[word.charAt(i)-'a'].is_a_word== true)  // if the character is present and has is_a_word = true and if this is the last character to be searched, only then return true because want to retrieve only complete word and not a pattern. So is_a_word = true is a necessity
                    return true;
                else
                    current=current.alphabets[word.charAt(i)-'a'];  // else go to the current charcter's node i.e next node
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */

    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for(int i=0;i<prefix.length();i++)
        {
            if(current.alphabets[prefix.charAt(i)-'a']==null)
                return false;
            else
            {
                if(current.alphabets[prefix.charAt(i)-'a']!=null && i==(prefix.length()-1))   // here we don't check for is_a_word = true because we just want to see if there exists any word that begins with this prefix, we don't have to return which word has this prefix.
                    return true;
                else
                    current=current.alphabets[prefix.charAt(i)-'a'];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie tr=new Trie();
        tr.insert("car");
        tr.insert("cat");
        tr.insert("cart");
        System.out.println(tr.search("car"));
        System.out.println(tr.startsWith("ca"));
    }


}
