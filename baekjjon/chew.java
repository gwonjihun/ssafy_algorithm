package gwonjihun.baekjjon;

import java.util.*;
public class chew {

	public static void main(String[] args) {
		int N = 20;
		int person = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {person,1});
		int cnt= 0;
		while(N!=0) {
			if(!q.isEmpty()) {
				int[] p = q.poll();
				cnt=(N>=p[1])? p[1]:N;
				N-= cnt;
				if(N==0) {
					System.out.println("마지막"+ p[0]+" "+cnt);
					
				}else {
					System.out.println(p[0]+" "+cnt+" "+N
							);
					p[1]++;
					q.offer(p);;
					q.offer(new int[] {++person,1});
				}
			}
		}
		
	}
}
