package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

/*
뒷날짜부터 시작한다.
*/
 public class Main_boj_1781 {
	static class Work implements Comparable<Work>{
		int dead;
		int item;
		public Work(int dead, int item) {
			this.dead = dead;
			this.item = item;
		}
		@Override
		public int compareTo(Work o) {
			// TODO Auto-generated method stub
			if(this.dead==o.dead) {
				return -Integer.compare(this.item, o.item);
			}
			return Integer.compare(this.dead, o.dead);
		}
		
	}
	public static void main(String[] args) throws Exception{
		
	}
}
