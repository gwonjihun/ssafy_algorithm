package gwonjihun.swea;

import java.util.*;
import java.io.*;

public class Solution_D3_9229_서울_20반_권지훈 {
	static int mg;
	static int c = 2;
	static int[] arr;	
	static int N;
	static int lg;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int Tc= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int T=1;T<=Tc;T++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			lg =  Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()," ");
			for(int i =0 ;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			mg = -1;
			comb(0,0, new int[2]);
			sb.append("#").append(T).append(" ").append(mg).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt,int start,int[] cho) {
		if(cnt==2) {
//			System.out.println(Arrays.toString(cho));
			int sum = cho[0]+cho[1];
			if(sum<=lg) mg = Math.max(sum,mg);
			return;
		}
		for(int i = start; i<N;i++) {
//			System.out.println(cnt);
			cho[cnt]= arr[i];
			comb(cnt+1,i+1,cho);
		}
	}
}
