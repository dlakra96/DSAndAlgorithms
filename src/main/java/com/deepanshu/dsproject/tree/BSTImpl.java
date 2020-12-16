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
		
		System.out.println("Choose any of the following options :- \n\n1. In-Order Traversal(default)\n2. Pre-Order Traversal\n3. Post-Order Traversal\n4. Level-Order Traversal" + 
														"\n5. Number of leaf nodes\n6. Number of non-leaf nodes\n7. Number of full nodes\n8. Height of tree\n9. Exit");
		
		char orderType = (char)br.read();
		
		switch(orderType)
		{
			case '1' : bstTree.printInOrder(bstTree.getRoot()); break;
			case '2' : bstTree.printPreOrder(bstTree.getRoot()); break;
			case '3' : bstTree.printPostOrder(bstTree.getRoot()); break;
			case '4' : bstTree.printlevelOrderTraversal(bstTree.getRoot());; break;
			case '5' : System.out.println(bstTree.returnNumOfLeafNodes(bstTree.getRoot())); break;
			case '6' : System.out.println(bstTree.returnNumOfNonLeafNodes(bstTree.getRoot())); break;
			case '7' : System.out.println(bstTree.returnNumOfFullNodes(bstTree.getRoot())); break;
			case '8' : System.out.println(bstTree.returnHeightOfTree(bstTree.getRoot())); break;
			case '9' : break;
 			default: bstTree.printInOrder(bstTree.getRoot()); break;
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\n\nThis program code is written by Deepanshu Lakra. Have a nice day !!!");
	}
}
