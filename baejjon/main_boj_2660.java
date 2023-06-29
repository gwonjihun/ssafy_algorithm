package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class main_boj_2660 {

	static int N;
	static ArrayList<Integer> graph[];
	static int[][] arr;
	static int[] scr;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i = 0 ; i < N+1;i++) {
			graph[i] = new ArrayList<Integer>();
		}
		arr =new int[N+1][N+1];
		
		scr = new int[N+1];
		while(true) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(s==-1&& e ==-1) break;
			arr[s][e]=1;
			arr[e][s]=1;
		}
		
		for(int i = 1;i<N+1;i++) {
			bfs(i);
		}
//		System.out.println(Arrays.toString(scr));
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1 ;i<N+1;i++) {
			if(min>scr[i]) {
				min = scr[i];
				list = new ArrayList<>();
				list.add(new Integer(i));
				cnt = 1;
			}else if(min==scr[i]) {cnt++;
				list.add(new Integer(i));
			}
		}
		
		System.out.println(min + " " + list.size());
		for(Integer a : list) {
			System.out.print(a+" ");
		}System.out.println();
	}
	static void bfs(int st) {
		int score=0;//
		boolean[] v = new boolean[N+1];//이걸로 방문 체크 -> 
		Deque<Integer> q = new ArrayDeque<Integer>();
		q.add(st);
		v[st]=true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i <size;i++) {
				int[] friends = arr[q.poll()];//001000
//				System.out.println(Arrays.toString(friends));
				for(int j = 1;j<=N;j++) {
					if(friends[j]==1&&!v[j]) {
//						System.out.println("j : "+ j + " score : " +score);
						v[j]=true;
						q.add(j);
					}
					
				}
			}
			score++;
		}
		scr[st] = score-1;
	}
}
