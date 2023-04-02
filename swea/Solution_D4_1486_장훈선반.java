package gwonjihun.swea;

import java.io.*;
import java.util.*;
public class Solution_D4_1486_장훈선반 {
	static int N, B;// 
	static int Min_values;
	static int[] lens;
	static boolean[] vis;
	public static void main(String args[]) throws Exception
	{
		
		/*
		   
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T= Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		StringBuilder sb =new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			lens = new int[N];
			vis = new boolean[N];
			Min_values = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0 ; i <N ; i++) {
				lens[i] = Integer.parseInt(st.nextToken());
			}
			perm(0,0);
			sb.append("#").append(test_case).append(" ").append(Min_values).append("\n");
		}
		System.out.println(sb);
	}
	static void perm(int start, int total) {
		if(total>=B) {
			if(Min_values>total-B) {
				Min_values=total-B;
			}
			return;
		}
		for(int i = start; i<N;i++) {
			if(!vis[i]) {
				vis[i]=true;
				perm(i,total+lens[i]);
				vis[i]=false;
			}
		}
	}
}