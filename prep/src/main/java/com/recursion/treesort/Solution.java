package com.recursion.treesort;
/*
Find the height of a binary tree
07/12/2020
*/

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class Solution {

	Node root;

	public static void main(String[] args) {
		Solution binaryTree = new Solution();
		binaryTree.root = new Node(1);
		binaryTree.root.left = new Node(2);
		binaryTree.root.right = new Node(3);
		binaryTree.root.left.left = new Node(4);
		System.out.println("Height of the binary tree : " + binaryTree.getHeight(binaryTree.root));

	}

	private int getHeight(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		int lDepth = getHeight(node.left);
		int rDepth = getHeight(node.right);

		return Math.max(lDepth, rDepth) + 1;
	}

}
