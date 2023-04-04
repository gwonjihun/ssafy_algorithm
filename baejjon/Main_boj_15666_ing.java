package gwonjihun.baejjon;

import java.io.*;
import java.util.*;
public class Main_boj_15666_ing {



	static int[] arr,b;
	static boolean[] v;
	static int N, R;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N];
		v = new boolean[N];
		b = new int[R];
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i= 0; i < N ; i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	static void perm(int cnt) {
		if(cnt == R) {
			for(int a : b) {
				sb.append(a+" ");
			}sb.append("\n");
			return;
		}
		for(int i = 0 ; i< N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = arr[i];
			perm(cnt+1);
			v[i]= false;
		}
	}
}