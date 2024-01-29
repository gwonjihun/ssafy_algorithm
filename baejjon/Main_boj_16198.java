package gwonjihun.baejjon;

import java.io.*;
import java.util.*;

public class Main_boj_16198 {

	static int N;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		for(int i = 0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		dfs(0,arr);
		System.out.println(answer);
	}
	
	static void dfs(int sum,int[] arr) {
		if(arr.length==2) {
			//arr가 2이다 곧 양 끝값만 남은 경우
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i= 1;i<arr.length-1;i++) {
			
			int[] temp = new int[arr.length-1];
			int idx = 0;
			for(int j=0;j<arr.length;j++) {
				if(j==i) continue;
				temp[idx++] = arr[j];
			}
			dfs(sum+(arr[i-1]*arr[i+1]),temp);
		}
	}
	
}
