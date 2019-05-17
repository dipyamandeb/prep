package com.day22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	public Node(int data) {
		super();
		this.data = data;
	}
}

public class Solution {

	static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			
			Node cur = q.remove();
			System.out.println(cur.data);
			
			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}
	}

	public static int getHeight(Node root) {
		if (root == null) {
			return -1;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size: ");
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			System.out.println("Enter value: ");
			int data = sc.nextInt();
			root = insert(root, data);
		}
		// int height = getHeight(root);
		// System.out.println(height);
		levelOrder(root);
	}

}