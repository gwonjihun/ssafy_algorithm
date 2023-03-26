package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_1916_?„œ?š¸_20ë°?_ê¶Œì??›ˆ {
	static int[][] arr;
	static boolean[][] use;
	static int N;
	static boolean[] v;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		use = new boolean[N][N];
		v = new boolean[N];
		dist = new int[N];
		Arrays.fill(dist, INF);
		
		for(int i = 0 ; i<N;i++) {
			for(int j = 0 ; j < N;j++) {
				if(i==j) continue;
				arr[i][j] = INF;
			}
		}
		
		int nodes = Integer.parseInt(br.readLine());
		for(int i = 0; i< nodes; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " " );
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			arr[from][to] = (arr[from][to]==0 && !use[from][to]) ? weight : Math.min(arr[from][to], weight);
			use[from][to] = true;
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " " );
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		
		dist[start] = 0;
		int min, current;
		for(int c = 0 ; c<N; c++) {
			current = -1;
			min = INF;

//			System.out.println(Arrays.toString(dist));
			for(int i = 0; i< N; i++ ) {
				if(!v[i] && min > dist[i]) {
					min = dist[i];
					current = i;
				}
			}
			if(current == -1) {break;}
			
			v[current] =true;
			
			for(int j = 0; j<N; j++) {
				if(!v[j] && arr[current][j] != INF && dist[j]> min + arr[current][j])
				{//if ë¬¸ì—?„œ?Š” ?´ë¯? ë°©ë¬¸?—¬ë¶??? jë¡? ê°? ?ˆ˜ ?ˆ?Š” ? •? ?¸ì§? ?Œ?‹¨?—¬ë¶?,ìµœì†Œê°’ì¸ì§??˜ ?—¬ë¶?ë¥? ì¡°ê±´?œ¼ë£? ì£¼ì–´?•¼?•œ?‹¤.
					dist[j] = min + arr[current][j];
				}
			}
		}
		System.out.println(dist[end]);
	}
}
