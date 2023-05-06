package gwonjihun.baejjon;

import java.io.*;
import java.util.*;



public class Main_boj_5639 {
	static class Node{
		Node left;
		int data;
		Node right;
		
		Node(int num){
			this.data = num;
		}
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
			if(n<this.data) {
				if(this.left==null) this.left= new Node(n);
				else this.left.insert(n);
			}else {
				if(this.right==null) this.right= new Node(n);
				else this.right.insert(n);
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));
		String input;
		while(true) {
			input = br.readLine();
			if(input== null || input=="")break;
			root.insert(Integer.parseInt(input));
		}
		post(root);
	}
	
	static void post(Node node) {
		if(node == null) return;
		post(node.left);
		post(node.right);
		System.out.println(node.data);
	}
}
