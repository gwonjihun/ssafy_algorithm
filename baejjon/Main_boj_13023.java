package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_13023 {

	static boolean[] visited;
	static int N,M;
	static List<Integer>[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N];
		visited=  new boolean[N];
		for(int i = 0 ; i < N ;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0 ; i <M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[s].add(e);
			arr[e].add(s);
		}
		
		for(int i = 0 ; i < N;i++) {
			if(flag(i,0)) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
	static boolean flag(int start,int depth) {
		if(depth==4) {
			return true;
		}
		visited[start]= true;
		for(int a : arr[start]) {
			if(!visited[a]) {
				if(flag(a,depth+1)) {
					return true;
				}
			}
		}
		visited[start] = false;
		
		return false;
	}
}
