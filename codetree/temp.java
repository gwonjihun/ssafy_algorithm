package gwonjihun.codetree;

import java.util.Comparator;
import java.util.PriorityQueue;


public class temp {
	static class a {
		int x, y;
		a(int x, int y){
			this.x = x;
			this.y= y;
		}
		@Override
		public String toString() {
			return "a [x=" + x + ", y=" + y + "]";
		}
	}
	static class test implements Comparator<a>{
		//여기서는 점프를할 떄 

		@Override
		public int compare(a o1, a o2) {
			// TODO Auto-generated method stub
			if(o1.x == o2.x)
				return o1.y-o2.y;
			return o1.x-o2.x;
		}
		
	}
	public static void main(String[] args) {
//		00 01 10 11
		 a[] ss = new a[4];
		 
		 ss[0] = new a(0,1);
		 ss[1] = new a(1,0);
		 ss[2] = new a(1,1);
		 ss[3] = new a(0,0);
		
		 PriorityQueue<a> q= new PriorityQueue<a>(new test()); 
		 
		 for(int i = 0 ; i <4;i++) {
			 q.offer(ss[i]);
		 }
		 for(int i = 0 ; i <4;i++) {
			 System.out.println(q.poll());
		 }
	}
}
