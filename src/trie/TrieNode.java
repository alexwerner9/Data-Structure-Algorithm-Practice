package trie;

class TrieNode {
	
	static final int ALPHABET_LENGTH = 26;

	public boolean isLeaf = false;
	public TrieNode[] children = new TrieNode[ALPHABET_LENGTH];
	
	public TrieNode() {
		
		for(int i = 0; i < ALPHABET_LENGTH; i++) {
			children[i] = null;
		}
		
	}
	
}