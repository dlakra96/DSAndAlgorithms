package com.deepanshu.dsproject.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

	private class Node {
		
		Character data;
		boolean isTerminal;
		HashMap<Character,Node> children;
		
		public Node(Character data,boolean isTerminal)
		{
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
		
	}
	
	private Node root;
	private int wordsCount;
	
	public int getWordsCount() {
		return wordsCount;
	}

	public void setWordsCount(int wordsCount) {
		this.wordsCount = wordsCount;
	}

	public Trie() {
		this.root = new Node('\0',false);
		this.wordsCount = 0;
	}
	
	public void addWord(String word)
	{
		this.addWord(root,word);
	}

	private void addWord(Node node, String word) {
		
		if(word.length() == 0)
		{
			if(!node.isTerminal)
			{
				node.isTerminal = true;
				this.wordsCount ++;	
			}
			return;
		}
		
		Character ch = word.charAt(0);
		String remainingWord = word.substring(1);
		Node child = node.children.get(ch);
		if(child == null)
		{
			child = new Node(ch,false);
			node.children.put(ch, child);
		}
		this.addWord(child, remainingWord);
	}
	
	public boolean searchWord(String word)
	{
		return this.searchWord(root,word);
	}

	private boolean searchWord(Node node, String word) {
		if(word.length() == 0)
			return node.isTerminal;
		Character ch = word.charAt(0);
		String remainingWord = word.substring(1);
		Node child = node.children.get(ch);
		if(child == null)
			return false;
		return searchWord(child,remainingWord);
		
	}
	
	public void removeWord(String word)
	{
		this.removeWord(root,word);
	}

	private void removeWord(Node node, String word) {
			if(word.length() == 0)
			{
				if(node.isTerminal)
				{
					node.isTerminal = false;
					this.wordsCount-- ;
					
				}
				return;
			}
			Character ch = word.charAt(0);
			String remainingWord = word.substring(1);
			Node child = node.children.get(ch);
			if(child == null)
				return;
			else
				removeWord(child,remainingWord);
			if(child.isTerminal == false && child.children.size() == 0)
				node.children.remove(ch);
			
	}
	
	public void displayTrie()
	{
		System.out.println("----------------------------------------------");
		displayTrie(this.root);
		System.out.println("----------------------------------------------");
	}

	private void displayTrie(Node node) {
		List<Character> keys = new ArrayList<>(node.children.keySet());
		String ans = node.data + "-> ";
		for(Character key : keys)
			ans += key + ", ";
		ans += ".";
		System.out.println(ans);
		for(Character key : keys)
			displayTrie(node.children.get(key));
	}
	
	
}
