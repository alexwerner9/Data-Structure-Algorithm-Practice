package trie;

public class Trie {

	static int ALPHABET_LENGTH = 26;
	TrieNode root = new TrieNode();
	
	public Trie() {
		insert("test");
		insert("tes");
		insert("te");
		System.out.println("t " + search("t"));
	}
	
	public void insert(String s) {
		
		TrieNode currNode = root;
		int letterInd;
		
		for(int i = 0; i < s.length(); i++) {
			letterInd = s.charAt(i) - 'a';
			if(currNode.children[letterInd] == null) {
				currNode.children[letterInd] = new TrieNode();
			}
			currNode = currNode.children[letterInd];
		}
		
		currNode.isLeaf = true;
		
	}
	
	public boolean search(String s) {
		
		TrieNode currNode = root;
		int letterInd;
		
		for(int i = 0; i < s.length(); i++) {
			letterInd = s.charAt(i) - 'a';
			if(currNode.children[letterInd] == null) {
				return false;
			} else {
				currNode = currNode.children[letterInd];
			}
		}
		
		if(currNode.isLeaf) {
			System.out.println(s + " is in Trie");
			return true;
		} else {
			System.out.println(s + " is NOT in Trie");
			return false;
		}
		
	}
	
}
