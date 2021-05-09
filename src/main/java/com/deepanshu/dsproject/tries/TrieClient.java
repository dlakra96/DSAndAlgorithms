package com.deepanshu.dsproject.tries;

public class TrieClient {
	public static void main(String args[])
	{
		Trie trie = new Trie();
		System.out.println("Initial Words Count :- " + trie.getWordsCount());
		trie.addWord("Deepanshu");
		trie.addWord("Manish");
		System.out.println("Words count after adding 2 words :- " + trie.getWordsCount());
		System.out.println("Is word 'Deepanshu' present ? " + trie.searchWord("Deepanshu"));
		System.out.println("Now removing word 'Deepanshu' from trie");
		trie.removeWord("Deepanshu");
		System.out.println("Is word 'Deepanshu' now present ? " + trie.searchWord("Deepanshu"));
		System.out.println("Now adding some more random words");
		trie.addWord("Sachin");
		trie.addWord("Chand");
		trie.addWord("Sanchit");
		trie.addWord("Sambit");
		trie.addWord("Mahendra");
		System.out.println("Now printing the trie formed so far as follows :- ");
		trie.displayTrie();
		System.out.println("Total number of words present in trie is :- " + trie.getWordsCount());
	}
}
