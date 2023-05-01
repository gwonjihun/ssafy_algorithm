package gwonjihun.codetree;

import java.io.*;
import java.util.*;
/*
1. 경주 격자가 필요한가?
*/
public class Main_토끼잡는다 {
	
	class ObjectSort implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	static class Rabbit {
		int pid, dist, j_cnt, x,y;
		
		public Rabbit(int pid, int dist) {
			this.pid= pid;
			this.dist = dist;
			this.j_cnt = 0;
			this.j_cnt = 1;
			this.j_cnt = 1;
			// TODO Auto-generated constructor stub
		}

	}
	
	static int[] dx = {0,0,1,-1}, dy= {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		
	}
}
