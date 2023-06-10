package gwonjihun.baejjon;

import java.util.PriorityQueue;

public class temp {

	static class node {
		int x, y, z;

		public node(int x) {
			this.x = x;
		}

		@Override
		public String toString() {
			return "node [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}

	public static void main(String[] args) {

		PriorityQueue<node> temp = new PriorityQueue<>((o1, o2) ->{ 
//			System.out.println(o1);
//			System.out.println(o2);
//			System.out.println("--------------------");
			return -1;}) ;
		for (int i = 5; i >= 0; i--) {
			temp.add(new node(i));
		}
		for (int i = 5; i >= 0; i--) {
			System.out.println(temp.poll());
		}
		
	}

}
