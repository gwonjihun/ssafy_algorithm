package gwonjihun.baejjon;

import java.util.*;
import java.io.*;

public class Main_boj_12851_서울_20반_권지훈2 {
	
	static int mins= Integer.MAX_VALUE;
	static boolean[] v = new boolean[100_001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		bfs(n,m,0);
		System.out.println(mins);
	}
	
	static void bfs(int n, int m,int cnt) {
		Deque<int[]> q = new ArrayDeque<>();
		q.addLast(new int[] {n,cnt});
		while(!q.isEmpty()) {
			int[] a = q.pollFirst();
			if(a[0]== m) {
				mins = a[1];

				
				return;
				
			}
			v[a[0]]= true;
			if(checks(a[0]*2)) q.addLast(new int[] {a[0]*2,a[1]});
			if(checks(a[0]+1)) q.addLast(new int[] {a[0]+1,a[1]+1});
			if(checks(a[0]-1)) q.addLast(new int[] {a[0]-1,a[1]+1});
			
		}
	}
	
	static boolean checks(int x) {
		if(0<=x && x <= 100_000 && !v[x])
			return true;
		
		return false;
	}
	static void dfs(int n, int m,int cnt) {
		if(n==m) {
			mins = Math.min(mins, cnt);
			return;
		}
		if(m>=0) {
		if(m%2==0) {
		dfs(n,m,cnt+1);
		}
		dfs(n,m-1,cnt+1);
		dfs(n,m+1,cnt+1);
		}
	}
}
