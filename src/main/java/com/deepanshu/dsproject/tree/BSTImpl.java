package com.deepanshu.dsproject.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BSTImpl {
		
	public static void main(String args[])
	{
		BinarySearchTree bstTree = new BinarySearchTree();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
		
		do {
			System.out.println("Enter node value(int) to be inserted in Binary Search Tree :-");
			bstTree.insertNode(Integer.parseInt(br.readLine()));
			System.out.println("Node has been inserted successfully in BST");
		    System.out.println("\nWant to add more nodes ? (y/n)");
		}
		while(br.readLine().equalsIgnoreCase("y"));
		
		System.out.println("Choose tree representation for printing nodes on the console :- \n1. In-Order (default)\n2. Pre-Order\n3. Post-Order");
		
		char orderType = (char)br.read();
		
		switch(orderType)
		{
			case '1' : bstTree.printInOrder(bstTree.getRoot()); break;
			case '2' : bstTree.printPreOrder(bstTree.getRoot()); break;
			case '3' : bstTree.printPostOrder(bstTree.getRoot()); break;
			default: bstTree.printInOrder(bstTree.getRoot()); break;
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n\nThis program code is written by Deepanshu Lakra. Have a nice day !!!");
	}
}
