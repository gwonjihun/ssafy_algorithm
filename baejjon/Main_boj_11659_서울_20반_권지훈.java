package gwonjihun.baejjon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11659_서울_20반_권지훈 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i<=N;i++) {
			dp[i]= dp[i-1]+arr[i-1];
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[e]-dp[s-1]).append("\n");
		}
		System.out.println(sb);
	}
}
