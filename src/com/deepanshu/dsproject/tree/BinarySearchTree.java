package com.deepanshu.dsproject.tree;

public class BinarySearchTree {
	
	class Node{
		
		public int data;
		public Node leftChild;
		public Node rightChild;
		public Node parent;
		
		public Node(int data)
		{
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
		}
	}
	
	private Node root;
	
	public BinarySearchTree()
	{
		this.root = null;
	}
	
	public Node findNode(int key)
	{
		Node temp = root;
		while(temp != root)
		{
			if(key < temp.data)
			{	
				if(temp.leftChild == null) return temp;
				temp = temp.leftChild;
			}
			if(key > temp.data)
			{
				if(temp.rightChild == null) return temp;
				temp = temp.rightChild;
			}
			else
				return temp;
		}
		return null;
	}
	
	
	/* 
	 * here while inserting node in BST we are assuming that the key value that we want to insert as a node doesn't already exist in BST
	 * or we can say that BST contains distinct key values 
	 */
	public void insertNode(int key)
	{
		Node newNode = new Node(key);
		if(root == null)
			root = newNode;
		else
		{
			Node temp = findNode(key);
			if(key > temp.data)
			{
				temp.rightChild = newNode;
				temp.rightChild.parent = temp;
			}
			else
			{
				temp.leftChild = newNode;
				temp.leftChild.parent = temp;
			}
			
		}
	}
	
	public boolean removeNode(int key)
	{
		Node nodeToRemove = findNode(key);
		
        // when the search key value doesn't get find in the tree hence node to be deleted is not present 		
		if(nodeToRemove.data != key)
			return false;
		// when there exists a node with the search key value passed as a parameter to this function, hence deletion will take place
		else
		{
			// case1 : when neither leftChild nor rightChild is present
			if(nodeToRemove.leftChild == null && nodeToRemove.rightChild == null)
			{
				if(nodeToRemove == root)
					root = null;
				else {
					if(nodeToRemove.parent.data > nodeToRemove.data)
						nodeToRemove.parent.leftChild = null;
					else
						nodeToRemove.parent.rightChild = null;
				}
				return true;
			}
			/* case2 : when both leftChild and rightChild are present 
			 *         here we can find either inorder successor that is the smallest element in the right subtree or
			 *         inorder predecessor that is the largest element in the left subtree
			 *         here we will go with inorder successor
			 */ 
			else if(nodeToRemove.leftChild != null && nodeToRemove.rightChild != null)
			{
					return false;
			}
			// case 3 : when we have either leftChild or rightChild is present
			else
			{
				if(nodeToRemove.rightChild != null)
				{
					nodeToRemove.rightChild.parent = nodeToRemove.parent;
					
					// now we will decide whether the right subtree of node to be deleted will become left subtree of its parent or right subtree of its parent
					if(nodeToRemove.rightChild.data < nodeToRemove.parent.data)
						nodeToRemove.parent.leftChild = nodeToRemove.rightChild;
					else 
						nodeToRemove.parent.rightChild = nodeToRemove.rightChild;

				}
				else
				{
					nodeToRemove.leftChild.parent = nodeToRemove.parent;
					
					// now we will decide whether the left subtree of the node to be deleted will become left subtree of its parent or right subtree of its parent
					if(nodeToRemove.leftChild.data < nodeToRemove.parent.data)
						nodeToRemove.parent.leftChild = nodeToRemove.leftChild;
					else
						nodeToRemove.parent.rightChild = nodeToRemove.leftChild;
				}
				
				return true;
			}
		}
		
	}
}
